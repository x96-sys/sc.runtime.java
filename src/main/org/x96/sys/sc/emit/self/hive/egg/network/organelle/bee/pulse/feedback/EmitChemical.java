package org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.feedback;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.EmitStimulus;
import org.x96.sys.sc.ir.synthetic.Chemical;

public class EmitChemical extends Emit<Chemical> {
    public EmitChemical(Chemical t) {
        super(t);
    }

    @Override
    public String toSC() {
        return new EmitStimulus(t.stimulus()).toSC();
    }
}
