package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.nerve.transmission.activity;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.EmitSignal;
import org.x96.sys.sc.ir.synthetic.Activity;

public class EmitActivity extends Emit<Activity> {
    public EmitActivity(Activity t) {
        super(t);
    }

    @Override
    public String toSC() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.signal().length; i++) {
            sb.append(new EmitSignal(t.signal()[i]).toSC());
            if (i < t.signal().length  - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
