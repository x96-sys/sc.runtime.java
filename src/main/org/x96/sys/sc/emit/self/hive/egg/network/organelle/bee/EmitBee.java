package org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.EmitPulse;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.Bee;
import org.x96.sys.sc.ir.synthetic.Pulse;

public class EmitBee extends Emit<Bee> {
    public EmitBee(Bee t) {
        super(t);
    }

    @Override
    public String toSC() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(":bug %s%n", new EmitId(t.id()).toSC()));
        String indent = " ".repeat(4);
        for (Pulse p: t.pulses()) {
            sb.append(String.format("%s%s%n", indent, new EmitPulse(p).toSC()));
        }
        sb.append(";\n");
        return sb.toString();
    }
}
