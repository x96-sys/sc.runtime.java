package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.synaptic.EmitSynaptic;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.EmitTransmission;
import org.x96.sys.sc.ir.synthetic.Nerve;
import org.x96.sys.sc.ir.synthetic.Synaptic;
import org.x96.sys.sc.ir.synthetic.Transmission;

public class EmitNerve extends Emit<Nerve> {
    public EmitNerve(Nerve nerve) {
        super(nerve);
    }

    @Override
    public String toSC() {
        return switch (t){
            case Synaptic synaptic -> new EmitSynaptic(synaptic).toSC();
            case Transmission transmission -> new EmitTransmission(transmission).toSC();
        };
    }
}
