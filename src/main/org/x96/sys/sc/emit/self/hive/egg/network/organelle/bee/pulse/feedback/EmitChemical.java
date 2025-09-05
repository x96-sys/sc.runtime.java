package org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.feedback;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.EmitStimulus;
import org.x96.sys.sc.ir.synthetic.Chemical;
import org.x96.sys.sc.ir.synthetic.Stimulus;

public class EmitChemical extends Emit<Chemical> {
    public EmitChemical(Chemical t) {
        super(t);
    }

    @Override
    public String toSC() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.stimulus().length; i++) {
            sb.append(new EmitStimulus(t.stimulus()[i]).toSC());
            if (i < t.stimulus().length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
