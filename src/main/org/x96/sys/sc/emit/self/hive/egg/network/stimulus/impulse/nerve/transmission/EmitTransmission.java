package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission;

import org.x96.sys.sc.emit.arch.DoubleEmit;
import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.EmitNerve;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.activity.EmitActivity;
import org.x96.sys.sc.ir.synthetic.Neuron;
import org.x96.sys.sc.ir.synthetic.Transmission;

public class EmitTransmission extends DoubleEmit<Transmission, Neuron> {
    public EmitTransmission(Transmission p, Neuron q) {
        super(p, q);
    }

    @Override
    public String toSC() {
        String activity = p.activity().map(a -> new EmitActivity(a).toSC()).orElse("");
        String nerve = p.nerve().map(n -> new EmitNerve(n, q).toSC()).orElse("");
        return String.format("(%s)%s", activity, nerve);
    }
}
