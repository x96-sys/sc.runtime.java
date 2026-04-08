package org.x96.sys.sc.emit;

import org.x96.sys.sc.ecology.biosphere.biome.Biome;
import org.x96.sys.sc.ir.*;

public interface EmitterVisitor {
    String visit(Biome biome, String indent);

    String visit(Tree tree, String indent);

    String visit(Hive hive, String indent);

    String visit(Egg egg, String indent);

    String visit(Network network, String indent);

    String visit(Organelle organelle, String indent);

    String visit(Bee bee, String indent);

    String visit(Rune rune, String indent);

    String visit(Pulse pulse, String indent);

    String visit(Swarm swarm, String indent);

    String visit(Connect connect, String indent);

    String visit(Habit habit, String indent);

    String visit(Stimulus stimulus, String indent);

    String visit(Hippocampus hippocampus, String indent);

    String visit(Impulse impulse, String indent);

    String visit(Dendrite dendrite, String indent);

    String visit(Chemical chemical, String indent);

    String visit(Nerve nerve, String indent);

    String visit(Neuron neuron, String indent);

    String visit(Synaptic synaptic, String indent);

    String visit(Transmission transmission, String indent);

    String visit(Activity activity, String indent);

    String visit(Signal signal, String indent);

    String visit(Serie serie, String indent);

    String visit(Schema schema, String indent);

    String visit(Neurotransmitter neurotransmitter, String indent);

    String visit(AminoAcid aminoAcid, String indent);

    String visit(Isoform isoform, String indent);

    String visit(Formula formula, String indent);

    String visit(Flow flow, String indent);

    String visit(Life life, String indent);

    String visit(Bundle bundle, String indent);

    String visit(Packet packet, String indent);

    String visit(Bond bond, String indent);

    String visit(Able able, String indent);

    String visit(Be be, String indent);

    String visit(Direction direction, String indent);

    String visit(Id id, String indent);

    String visit(Nb16 nb16, String indent);

    String visit(Text text, String indent);

    String visit(Endo endo, String indent);

    String visit(Spore spore, String indent);

    String visit(Axoneme axoneme, String indent);

    String visit(Nature nature, String indent);
}
