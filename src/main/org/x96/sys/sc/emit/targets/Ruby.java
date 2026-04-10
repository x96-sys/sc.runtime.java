package org.x96.sys.sc.emit.targets;

import org.x96.sys.sc.emit.Emitter;
import org.x96.sys.sc.ir.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ruby extends Emitter {

    public Ruby() {
        this.SS = (char) 0x22;
        this.IL = 2;
        this.I = " ".repeat(IL);
    }

    @Override
    public String visit(Bee bee, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:bug %s%n", indent, new String(bee.id().raw())));
        String childIndent = indent + "    ";
        for (Dendrite d : bee.dendrites()) {
            sb.append(d.accept(this, childIndent));
            sb.append("\n");
        }
        for (Pulse p : bee.pulses()) {
            sb.append(p.accept(this, childIndent));
        }
        sb.append(indent).append(";\n");
        return sb.toString();
    }

    @Override
    public String visit(Rune rune, String indent) {
        String childIndent = "\n" + indent + I;

        String insignias =
                Stream.of(rune.directions())
                        .map(direction -> direction.accept(this, childIndent))
                        .collect(Collectors.joining());

        String pulses =
                Stream.of(rune.pulses())
                        .map(pulse -> pulse.accept(this, childIndent))
                        .collect(Collectors.joining());

        return String.format(
                "%s:totem %s%s%s;%n", indent, rune.id().accept(this, ""), insignias, pulses);
    }

    @Override
    public String visit(Pulse pulse, String indent) {
        String i = " ".repeat(4);
        String id = new String(pulse.id().raw());
        String schema = pulse.schema().map(s -> s.accept(this, "")).orElse("");
        String flow = pulse.flow().map(f -> " !" + f.accept(this, " ")).orElse("");
        String child = "\n" + indent + i;
        String chemical = pulse.chemical().map(c -> c.accept(this, child)).orElse("");
        String finiPulse = pulse.chemical().isEmpty() ? ";" : "\n" + indent + ";";
        return String.format(
                "%s:ethics %s%s%s%s%s%n", indent, id, schema, flow, chemical, finiPulse);
    }

    @Override
    public String visit(Swarm swarm, String indent) {
        return String.format("%s:logos %s;%n%n", indent, new String(swarm.id().raw()));
    }

    @Override
    public String visit(Connect connect, String indent) {
        return String.format("%s:know ':%s'%n", indent, new String(connect.id().raw()));
    }

    @Override
    public String visit(Habit habit, String indent) {
        return String.format("%s:skill :%s;", indent, new String(habit.id().raw()));
    }

    @Override
    public String visit(Hippocampus hippocampus, String indent) {
        String nature = visit(hippocampus.nature(), indent);
        String id = new String(hippocampus.id().raw());
        String signal = hippocampus.signal().map(s -> s.accept(this, indent)).orElse("");
        return String.format("%s%s%s = %s", indent, nature, id, signal);
    }

    @Override
    public String visit(Impulse impulse, String indent) {
        if (impulse.neuron().isPrimitive() && impulse.nerve().isEmpty()) {
            return visit(impulse.neuron(), indent);
        }
        String neuron = impulse.neuron().accept(this, "");
        String nerve = impulse.nerve().map(n -> n.accept(this, "")).orElse("");
        return String.format("%s%s%s", indent, neuron, nerve);
    }

    @Override
    public String visit(Dendrite dendrite, String indent) {
        String gene = dendrite.neurotransmitter().aminoAcidName();
        String iso = dendrite.neurotransmitter().isoform().accept(this, "");
        String optional = dendrite.neurotransmitter().isOptional() ? "?" : "";
        return String.format("%s:gene %s%s %s;", indent, gene, optional, iso);
    }

    @Override
    public String visit(Chemical chemical, String indent) {
        return Stream.of(chemical.stimulus())
                .map(stimulus -> stimulus.accept(this, indent))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String visit(Nerve nerve, String indent) {
        return nerve.accept(this, indent);
    }

    @Override
    public String visit(Neuron neuron, String indent) {
        if (!neuron.isPrimitive()) {
            throw new RuntimeException("me implemente:");
        }
        return switch (neuron) {
            case Nb16 nb16 -> throw new RuntimeException("me implemente:");
            case Text text -> visit(text, indent);
            default -> throw new RuntimeException("me implemente");
        };
    }

    @Override
    public String visit(Synaptic synaptic, String indent) {
        String nerve = synaptic.nerve().map(n -> n.accept(this, indent)).orElse("");
        return indent + "." + new String(synaptic.id().raw()) + nerve;
    }

    @Override
    public String visit(Transmission transmission, String indent) {
        String activity = transmission.activity().map(a -> a.accept(this, indent)).orElse("");
        String nerve = transmission.nerve().map(n -> n.accept(this, indent)).orElse("");
        return String.format("%s(%s)%s", indent, activity, nerve);
    }

    @Override
    public String visit(Activity activity, String indent) {
        return Stream.of(activity.signal())
                .map(signal -> signal.accept(this, indent))
                .collect(Collectors.joining(", "));
    }

    @Override
    public String visit(Signal signal, String indent) {
        return signal.accept(this, indent);
    }

    @Override
    public String visit(Serie serie, String indent) {
        StringBuilder sb = new StringBuilder();
        if (serie.axoneme().isPresent()) {
            sb.append("&");
            sb.append(serie.axoneme().get().h());
        }
        sb.append("[");
        String serialized =
                Stream.of(serie.serialized())
                        .map(s -> s.accept(this, ""))
                        .collect(Collectors.joining(" "));
        sb.append(serialized);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String visit(Schema schema, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String neurotransmitters =
                Stream.of(schema.neurotransmitters())
                        .map(n -> n.accept(this, indent))
                        .collect(Collectors.joining(", "));
        sb.append(neurotransmitters);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visit(Neurotransmitter neurotransmitter, String indent) {
        String k = neurotransmitter.aminoAcid().map(a -> a.accept(this, "") + ": ").orElse(":");
        String v = neurotransmitter.isoform().accept(this, "");
        // This logic needs to be improved, it's not quite right.
        String mods = "";
        return String.format("%s%s%s", mods, k, v);
    }

    @Override
    public String visit(Isoform isoform, String indent) {
        return new String(isoform.id().raw());
    }

    @Override
    public String visit(Formula formula, String indent) {
        return formula.h();
    }

    @Override
    public String visit(Flow flow, String indent) {
        return flow.accept(this, indent);
    }

    @Override
    public String visit(Life life, String indent) {
        if (!life.state()) {
            throw new RuntimeException("dead life can't be emitted");
        }
        return "0x0";
    }

    @Override
    public String visit(Bundle bundle, String indent) {
        return "TODO: Bundle";
    }

    @Override
    public String visit(Packet packet, String indent) {
        return "TODO: Packet";
    }

    @Override
    public String visit(Bond bond, String indent) {
        return "TODO: Bond";
    }

    @Override
    public String visit(Able able, String indent) {
        return String.format("%s:can '%s'%n", indent, able.id().accept(this, ""));
    }

    @Override
    public String visit(Be be, String indent) {
        return String.format("%s:as %s;", indent, be.id().accept(this, ""));
    }

    @Override
    public String visit(Nb16 nb16, String indent) {
        return String.format("0x%X", nb16.raw());
    }

    @Override
    public String visit(Endo endo, String indent) {
        return "$";
    }

    @Override
    public String visit(Spore spore, String indent) {
        return "TODO: Spore";
    }

    @Override
    public String visit(Axoneme axoneme, String indent) {
        return axoneme.h();
    }

    @Override
    public String visit(Nature nature, String indent) {
        return "";
    }
}
