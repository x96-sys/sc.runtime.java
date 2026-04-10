package org.x96.sys.sc.emit.targets;

import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.emit.Emitter;
import org.x96.sys.sc.ir.*;

public class Zig extends Emitter {

    public Zig() {
        this.SS = (char) 0x22; // Use double quotes for Zig strings
    }

    @Override
    public String visit(Biome biome, String indent) {
        StringBuilder sb = new StringBuilder();

        // Only add file header if there are organisms
        if (!biome.organisms.isEmpty()) {
            Id firstKey = biome.organisms.keySet().stream().findFirst().get();
            String fileName = new String(firstKey.raw());
            String path = new String(biome.bioName.raw()).replace('.', '/');
            String pkg = String.format("%s// %s/%s.zig%n%n", indent, path, fileName);
            sb.append(pkg);
        }

        sb.append(biome.chronicle.accept(this, indent));
        for (Organelle o : biome.organisms.values()) {
            sb.append(o.accept(this, indent));
        }
        return sb.toString();
    }

    @Override
    public String visit(Bee bee, String indent) {
        StringBuilder sb = new StringBuilder();
        String name = new String(bee.id().raw());
        sb.append(String.format("%s%s %s %s = %s {%n", indent, "pub", "const", name, "struct"));
        String childIndent = indent + I;
        for (Dendrite d : bee.dendrites()) {
            sb.append(d.accept(this, childIndent));
            sb.append("\n");
        }
        for (Pulse p : bee.pulses()) {
            sb.append(p.accept(this, childIndent));
        }
        sb.append(indent).append("}");
        return sb.toString();
    }

    @Override
    public String visit(Rune rune, String indent) {
        String totem = rune.id().accept(this, "");
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%spub const %s = enum {\n", indent, totem));

        String childIndent = indent + I;
        for (Direction direction : rune.directions()) {
            sb.append(String.format("%s%s,\n", childIndent, direction.accept(this, "")));
        }

        sb.append(String.format("%s};\n", indent));
        return sb.toString();
    }

    @Override
    public String visit(Pulse pulse, String indent) {
        return "";
    }

    @Override
    public String visit(Swarm swarm, String indent) {
        return String.format("// %s%n%n", swarm.id().accept(this, "").replace('.', '/'));
    }

    @Override
    public String visit(Connect connect, String indent) {
        return "";
    }

    @Override
    public String visit(Habit habit, String indent) {
        return "";
    }

    @Override
    public String visit(Hippocampus hippocampus, String indent) {
        String id = new String(hippocampus.id().raw());
        String value = hippocampus.signal().map(s -> s.accept(this, "")).orElse("undefined");

        // Zig constants use 'const NAME = value;' syntax
        return String.format("%sconst %s = %s;", indent, id, value);
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
        String optional = dendrite.neurotransmitter().isOptional() ? "?*" : "";
        return String.format("%s%s: %s%s,", indent, gene, optional, iso);
    }

    @Override
    public String visit(Chemical chemical, String indent) {
        return "";
    }

    @Override
    public String visit(Nerve nerve, String indent) {
        return "";
    }

    @Override
    public String visit(Synaptic synaptic, String indent) {
        return "";
    }

    @Override
    public String visit(Transmission transmission, String indent) {
        return "";
    }

    @Override
    public String visit(Activity activity, String indent) {
        return "";
    }

    @Override
    public String visit(Signal signal, String indent) {
        return "";
    }

    @Override
    public String visit(Serie serie, String indent) {
        return "";
    }

    @Override
    public String visit(Schema schema, String indent) {
        return "";
    }

    @Override
    public String visit(Neurotransmitter neurotransmitter, String indent) {
        return "";
    }

    @Override
    public String visit(Isoform isoform, String indent) {
        return new String(isoform.id().raw());
    }

    @Override
    public String visit(Formula formula, String indent) {
        return "";
    }

    @Override
    public String visit(Flow flow, String indent) {
        return "";
    }

    @Override
    public String visit(Life life, String indent) {
        return "";
    }

    @Override
    public String visit(Bundle bundle, String indent) {
        return "";
    }

    @Override
    public String visit(Packet packet, String indent) {
        return "";
    }

    @Override
    public String visit(Bond bond, String indent) {
        return "";
    }

    @Override
    public String visit(Able able, String indent) {
        return "";
    }

    @Override
    public String visit(Be be, String indent) {
        return "";
    }

    @Override
    public String visit(Nb16 nb16, String indent) {
        return "";
    }

    @Override
    public String visit(Endo endo, String indent) {
        return "";
    }

    @Override
    public String visit(Spore spore, String indent) {
        return "";
    }

    @Override
    public String visit(Axoneme axoneme, String indent) {
        return "";
    }

    @Override
    public String visit(Nature nature, String indent) {
        return "";
    }
}
