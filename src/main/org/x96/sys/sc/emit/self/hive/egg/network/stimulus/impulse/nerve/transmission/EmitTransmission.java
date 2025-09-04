package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.EmitNerve;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.activity.EmitActivity;
import org.x96.sys.sc.ir.synthetic.Transmission;

public class EmitTransmission extends Emit<Transmission> {
    public EmitTransmission(Transmission t) {
        super(t);
    }

    @Override
    public String toSC() {
        String activity = t.activity().map(a -> new EmitActivity(a).toSC()).orElse("");
        String nerve = t.nerve().map(n -> new EmitNerve(n).toSC()).orElse("");
        return String.format("(%s)%s", activity, nerve);
    }
}
