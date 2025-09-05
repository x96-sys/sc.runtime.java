package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve;

import org.x96.sys.sc.emit.arch.DoubleEmit;
import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.synaptic.EmitSynaptic;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.EmitTransmission;
import org.x96.sys.sc.ir.synthetic.Nerve;
import org.x96.sys.sc.ir.synthetic.Neuron;
import org.x96.sys.sc.ir.synthetic.Synaptic;
import org.x96.sys.sc.ir.synthetic.Transmission;

public class EmitNerve extends DoubleEmit<Nerve, Neuron> {
    public EmitNerve(Nerve p, Neuron q) {
        super(p, q);
    }

    @Override
    public String toSC() {
        return switch (p){
            case Synaptic synaptic -> new EmitSynaptic(synaptic, q).toSC();
            case Transmission transmission -> new EmitTransmission(transmission, q).toSC();
        };
    }
}
