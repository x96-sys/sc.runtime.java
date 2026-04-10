package org.x96.sys.sc.emit.targets;

import org.x96.sys.sc.emit.Emitter;
import org.x96.sys.sc.ir.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Haskell extends Emitter {

    @Override
    public String visit(Bee bee, String indent) {
        StringBuilder sb = new StringBuilder();

        // TypeScript interface for the bug
        sb.append(String.format("%sinterface %s {\n", indent, new String(bee.id().raw())));
        String childIndent = indent + "  ";

        for (Dendrite d : bee.dendrites()) {
            sb.append(d.accept(this, childIndent));
            sb.append("\n");
        }

        sb.append(indent).append("}\n");
        return sb.toString();
    }

    @Override
    public String visit(Rune rune, String indent) {
        // TypeScript enum for totem
        String typeName = new String(rune.id().raw());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%senum %s {\n", indent, typeName));

        // Handle directions as enum values
        String childIndent = indent + "    ";
        for (int i = 0; i < rune.directions().length; i++) {
            String enumValue = rune.directions()[i].accept(this, "");
            sb.append(String.format("%s%s,\n", childIndent, enumValue));
        }

        sb.append(indent).append("};\n");
        return sb.toString();
    }

    @Override
    public String visit(Pulse pulse, String indent) {
        String id = new String(pulse.id().raw());
        String type = pulse.schema().map(s -> s.accept(this, "")).orElse("unknown");
        String optional = pulse.flow().isPresent() ? "?" : "";

        return String.format("%s%s%s: %s;", indent, id, optional, type);
    }

    @Override
    public String visit(Swarm swarm, String indent) {
        // TypeScript comment for module path
        String path = new String(swarm.id().raw()).replace('.', '/');
        return String.format("%s// %s\n\n", indent, path);
    }

    @Override
    public String visit(Connect connect, String indent) {
        return ""; // Don't generate direct output, just accumulate import
    }

    @Override
    public String visit(Habit habit, String indent) {
        // TypeScript function type or skill
        return String.format("%s// Skill: %s\n", indent, new String(habit.id().raw()));
    }

    @Override
    public String visit(Hippocampus hippocampus, String indent) {
        String id =
                new String(hippocampus.id().raw())
                        .toLowerCase(); // Haskell functions start with lowercase
        String value = hippocampus.signal().map(s -> s.accept(this, "")).orElse("undefined");

        // Determine Haskell type based on signal content
        String haskellType = determineHaskellType(hippocampus.signal().orElse(null));

        // Haskell syntax: type signature on one line, definition on next line
        return String.format("%s%s :: %s%n%s%s = %s", indent, id, haskellType, indent, id, value);
    }

    private String determineHaskellType(Signal signal) {
        if (signal == null) {
            throw new RuntimeException("me implemente");
        }

        return switch (signal) {
            case Impulse impulse -> {
                if (impulse.neuron() instanceof Text) {
                    yield "String";
                } else if (impulse.neuron() instanceof Nb16) {
                    yield "Int";
                } else {
                    throw new RuntimeException("me implemente");
                }
            }
            default -> throw new RuntimeException("me implemente");
        };
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
        String type = dendrite.neurotransmitter().isoform().accept(this, "");
        String optional = dendrite.neurotransmitter().isOptional() ? "?" : "";

        // Map SC types to TypeScript types
        String tsType = mapScToTsType(type);

        return String.format("%s%s%s: %s;", indent, gene, optional, tsType);
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
    public String visit(Synaptic synaptic, String indent) {
        String nerve = synaptic.nerve().map(n -> n.accept(this, indent)).orElse("");
        return "." + new String(synaptic.id().raw()) + nerve;
    }

    @Override
    public String visit(Transmission transmission, String indent) {
        String activity = transmission.activity().map(a -> a.accept(this, indent)).orElse("");
        String nerve = transmission.nerve().map(n -> n.accept(this, indent)).orElse("");
        return String.format("(%s)%s", activity, nerve);
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
        sb.append("[");

        String content =
                Stream.of(serie.serialized())
                        .map(signal -> signal.accept(this, ""))
                        .collect(Collectors.joining(", "));

        sb.append(content);
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
        String k = neurotransmitter.aminoAcid().map(a -> a.accept(this, "") + ": ").orElse("");
        String v = neurotransmitter.isoform().accept(this, "");
        String mods = "";
        return String.format("%s%s%s", mods, k, mapScToTsType(v));
    }

    @Override
    public String visit(Isoform isoform, String indent) {
        return mapScToTsType(new String(isoform.id().raw()));
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
        return "null";
    }

    @Override
    public String visit(Bundle bundle, String indent) {
        return "any"; // TODO: improve bundle mapping
    }

    @Override
    public String visit(Packet packet, String indent) {
        return "object"; // TODO: improve packet mapping
    }

    @Override
    public String visit(Bond bond, String indent) {
        return "any"; // TODO: improve bond mapping
    }

    @Override
    public String visit(Able able, String indent) {
        return String.format("%s// can %s\n", indent, able.id().accept(this, ""));
    }

    @Override
    public String visit(Be be, String indent) {
        return String.format("%s// as %s\n", indent, be.id().accept(this, ""));
    }

    @Override
    public String visit(Nb16 nb16, String indent) {
        return String.format("0x%X", nb16.raw());
    }

    @Override
    public String visit(Text text, String indent) {
        return String.format("\"%s\"", new String(text.raw()));
    }

    @Override
    public String visit(Endo endo, String indent) {
        return "this";
    }

    @Override
    public String visit(Spore spore, String indent) {
        return "any"; // TODO: improve spore mapping
    }

    @Override
    public String visit(Axoneme axoneme, String indent) {
        return axoneme.h();
    }

    @Override
    public String visit(Nature nature, String indent) {
        return switch (nature) {
            case FIXED -> "readonly ";
            default -> "";
        };
    }

    @Override
    public String visit(Id id, String indent) {
        return new String(id.raw());
    }

    // Map SC types to TypeScript types
    private String mapScToTsType(String scType) {
        return switch (scType) {
            case "Hex" -> "number";
            case "Echo" -> "string";
            case "Bool" -> "boolean";
            case "LocalDate" -> "Date";
            default -> scType; // Keep custom types as-is
        };
    }
}
