package org.x96.sys.sc.buzz.interpreter;

import org.x96.sys.buzz.Buzz;
import org.x96.sys.sc.ir.Endo;
import org.x96.sys.sc.ir.Id;
import org.x96.sys.sc.ir.Nb16;
import org.x96.sys.sc.ir.Neuron;
import org.x96.sys.sc.ir.Synaptic;
import org.x96.sys.sc.ir.Text;

public class BuzzNeuronUnknowSynaptic extends Buzz {
    public static final int CODE = 0xE4;

    public BuzzNeuronUnknowSynaptic(Neuron neuron, Synaptic synaptic) {
        super(
                CODE,
                BuzzNeuronUnknowSynaptic.class.getSimpleName(),
                explainNeuronUnknowSynaptic(neuron, synaptic));
    }

    public static String explainNeuronUnknowSynaptic(Neuron neuron, Synaptic synaptic) {
        String neuronStr =
                switch (neuron) {
                    case Id id -> new String(id.raw());
                    case Text text -> new String(text.raw());
                    case Nb16 nb16 -> String.format("0x%X", nb16.raw());
                    case Endo ignored -> "$";
                };
        return String.format(
                "forager [%s] unknow course [%s]", neuronStr, new String(synaptic.id().raw()));
    }
}
