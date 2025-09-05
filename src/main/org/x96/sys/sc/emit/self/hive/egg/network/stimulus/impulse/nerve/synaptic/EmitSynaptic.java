package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.synaptic;

import org.x96.sys.sc.emit.arch.DoubleEmit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.EmitNerve;
import org.x96.sys.sc.ir.synthetic.Neuron;
import org.x96.sys.sc.ir.synthetic.Synaptic;

public class EmitSynaptic extends DoubleEmit<Synaptic, Neuron> {


    public EmitSynaptic(Synaptic p, Neuron q) {
        super(p, q);
    }

    @Override
    public String toSC() {

        String point = ".";
        String nerve = "";
        if (p.nerve().isPresent()) {
            nerve = new EmitNerve(p.nerve().get(), q).toSC();
        }
        return point + new EmitId(p.id()).toSC() + nerve;
    }
}
