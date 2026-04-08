package org.x96.sys.sc.emit;

import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.ir.*;

public abstract class Emitter implements EmitterVisitor {

    public int IL;
    public String I;
    public char SS; // stringSentinel

    public Emitter() {
        this.SS = (char) 0x27;
        this.IL = 4;
        this.I = " ".repeat(IL);
    }

    @Override
    public String visit(Biome biome, String indent) {
        StringBuilder sb = new StringBuilder();
        if (biome.bioName.raw().length > 0) {
            sb.append(new Swarm(biome.bioName).accept(this, indent));
        }
        sb.append(biome.chronicle.accept(this, indent));
        for (Organelle o : biome.organisms.values()) {
            sb.append(o.accept(this, indent));
        }
        return sb.toString();
    }

    @Override
    public String visit(Tree tree, String indent) {
        return tree.hive().accept(this, indent);
    }

    @Override
    public String visit(Hive hive, String indent) {
        return hive.egg().accept(this, indent);
    }

    @Override
    public String visit(Egg egg, String indent) {
        StringBuilder sb = new StringBuilder();
        for (Network network : egg.network()) {
            sb.append(network.accept(this, indent));
        }
        return sb.toString();
    }

    @Override
    public String visit(Network network, String indent) {
        return switch (network) {
            case Organelle organelle -> organelle.accept(this, indent);
            case Stimulus stimulus -> stimulus.accept(this, indent);
        };
    }

    @Override
    public String visit(Organelle organelle, String indent) {
        return switch (organelle) {
            case Bee bee -> visit(bee, indent);
            case Rune rune -> visit(rune, indent);
            case Pulse pulse -> visit(pulse, indent);
            case Swarm swarm -> visit(swarm, indent);
            case Connect connect -> visit(connect, indent);
            case Habit habit -> visit(habit, indent);
        };
    }

    @Override
    public String visit(Stimulus stimulus, String indent) {
        return switch (stimulus) {
            case Hippocampus hippocampus -> visit(hippocampus, indent);
            case Impulse impulse -> visit(impulse, indent);
        };
    }

    @Override
    public String visit(Direction direction, String indent) {
        return String.format(
                "%s%s%s",
                indent,
                new String(direction.id().raw()),
                direction.schema().map(s -> s.accept(this, "")).orElse(""));
    }

    @Override
    public String visit(AminoAcid aminoAcid, String indent) {
        String id = aminoAcid.id().map(i -> new String(i.raw())).orElse("");
        return String.format("%s%s", indent, id);
    }

    @Override
    public String visit(Id id, String indent) {
        return String.format("%s%s", indent, new String(id.raw()));
    }

    @Override
    public String visit(Text text, String indent) {
        return String.format("%s%s%s", this.SS, new String(text.raw()), this.SS);
    }

    @Override
    public String visit(Neuron neuron, String indent) {
        if (!neuron.isPrimitive()) {
            throw new RuntimeException("me implemente:");
        }
        return switch (neuron) {
            case Nb16 nb16 -> visit(nb16, indent);
            case Text text -> visit(text, indent);
            default -> throw new RuntimeException("me implemente");
        };
    }
}
