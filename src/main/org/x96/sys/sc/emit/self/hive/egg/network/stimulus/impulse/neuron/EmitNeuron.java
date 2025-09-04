package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.neuron;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.Neuron;

public class EmitNeuron extends Emit<Neuron> {
    public EmitNeuron(Neuron neuron) {
        super(neuron);
    }

    @Override
    public String toSC() {
        return String.format("%s", new EmitId(t.id()).toSC());
    }
}
