package org.x96.sys.sc.ecology.biosphere.biome;

import org.x96.sys.sc.buzz.interpreter.BuzzNeuronUnknowSynaptic;
import org.x96.sys.sc.ecology.biosphere.biome.sanctuary.Sanctuary;
import org.x96.sys.sc.ecology.biosphere.biome.sanctuary.Specimen;
import org.x96.sys.sc.emit.EmitterVisitor;
import org.x96.sys.sc.ir.*;

import java.util.HashMap;

// STACK
public class Biome {
    public final Id bioName;
    public HashMap<Id, Organelle> organisms;
    public Sanctuary chronicle; // HEAP

    public Biome(Id bioName) {
        this.bioName = bioName;
        this.organisms = new HashMap<>();
        this.chronicle = new Sanctuary(this);
    }

    public boolean reply(Neuron neuron, Synaptic synaptic) {
        return attention(neuron.bug()).reply(synaptic.id());
    }

    public Pulse pulse(Neuron neuron, Synaptic synaptic) {
        if (!reply(neuron, synaptic)) {
            throw new BuzzNeuronUnknowSynaptic(neuron, synaptic);
        }
        return attention(neuron.bug()).pulse(synaptic.id()).get();
    }

    public Organelle attention(Id id) {
        return organisms.get(id);
    }

    public void integrates(Id id, Organelle organelle) {
        this.organisms.put(id, organelle);
    }

    public boolean integrated(Id id) {
        if (id.isPrimitive()) {
            return true;
        }
        return organisms.containsKey(id) || chronicle.inZoo(id);
    }

    public void imortalize(Hippocampus hippocampus) {
        if (hippocampus.signal().isEmpty()) {
            throw new RuntimeException("Signal is empty");
        }
        switch (hippocampus.signal().get()) {
            case Activity activity -> {
                throw new RuntimeException("me implemente");
            }
            case Impulse impulse -> {
                if (impulse.nerve().isPresent()) {
                    throw new RuntimeException("me implemente");
                }
                Specimen specimen = new Specimen(hippocampus.id(), impulse.neuron());
                chronicle.imortalize(specimen);
            }
            case Serie serie -> {
                throw new RuntimeException("me implemente");
            }
            case Wave wave -> {
                throw new RuntimeException("me implemente");
            }
        }
    }

    public void eco(String indent) {
        System.out.printf("%s🌍 [biome] [%s]%n", indent, new String(bioName.raw()));
        String child = indent + " ".repeat(4);
        System.out.printf("%s🐞 [organisms] [%s]%n", child, organisms.size());
        chronicle.eco(child);
    }

    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
