package org.x96.sys.sc.emit.targets;

import org.x96.sys.sc.emit.Emitter;
import org.x96.sys.sc.ir.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java extends Emitter {

    public Java() {
        this.SS = (char) 0x22; // Use double quotes for Java strings
    }

    @Override
    public String visit(Bee bee, String indent) {
        StringBuilder sb = new StringBuilder();
        String className = new String(bee.id().raw());

        // Build record parameters from dendrites (genes)
        String parameters =
                Stream.of(bee.dendrites())
                        .map(d -> d.accept(this, ""))
                        .collect(Collectors.joining(", "));

        sb.append(String.format("%spublic record %s(%s) {%n", indent, className, parameters));
        sb.append(String.format("%s}%n", indent));

        return sb.toString();
    }

    @Override
    public String visit(Rune rune, String indent) {
        String totem = rune.id().accept(this, "");
        String childIndent = "\n" + indent + I;

        String insignias =
                Stream.of(rune.directions())
                        .map(direction -> direction.accept(this, childIndent))
                        .collect(Collectors.joining(","));

        String pulses =
                Stream.of(rune.pulses())
                        .map(pulse -> pulse.accept(this, childIndent))
                        .collect(Collectors.joining());

        return String.format("%spublic enum %s {%s%s}%n", indent, totem, insignias, pulses);
    }

    @Override
    public String visit(Pulse pulse, String indent) {
        return "";
    }

    @Override
    public String visit(Swarm swarm, String indent) {
        return String.format("package %s;%n%n", swarm.id().accept(this, ""));
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
        String nature = visit(hippocampus.nature(), "");
        String id = new String(hippocampus.id().raw());
        String signal = hippocampus.signal().map(s -> s.accept(this, indent)).orElse("");

        // Determine the type based on the signal content
        String type = determineJavaType(hippocampus.signal().orElse(null));

        return String.format(
                "%s%s %s %s %s %s = %s;", indent, "public", nature, "static", type, id, signal);
    }

    private String determineJavaType(Signal signal) {
        if (signal == null) {
            return "";
        }

        // Check if the signal contains a Text (string literal)
        return switch (signal) {
            case Impulse impulse -> {
                if (impulse.neuron() instanceof Text) {
                    yield "String";
                } else if (impulse.neuron() instanceof Nb16) {
                    yield "int";
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
        String baseType = mapTypeToJava(dendrite.neurotransmitter().isoform().id());
        String fieldName = dendrite.neurotransmitter().aminoAcidName();

        // Check if the field is optional (has ? modifier)
        String javaType;
        if (dendrite.neurotransmitter().isOptional()) {
            javaType = String.format("Optional<%s>", baseType);
        } else {
            javaType = baseType;
        }
        String array = dendrite.neurotransmitter().isArray() ? "[]" : "";

        return String.format("%s%s %s", javaType, array, fieldName);
    }

    private String mapTypeToJava(Id typeId) {
        String typeName = new String(typeId.raw());
        return switch (typeName) {
            case "Hex" -> "Integer";
            case "Echo" -> "String";
            default -> typeName; // fallback to original name
        };
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
        return "";
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
        return indent
                + switch (nature) {
                    case MUTABLE -> "";
                    case FIXED -> "final";
                };
    }
}
