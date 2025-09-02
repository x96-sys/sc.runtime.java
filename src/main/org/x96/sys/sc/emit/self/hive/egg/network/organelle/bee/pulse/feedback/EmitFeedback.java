package org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.feedback;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.EmitStimulus;
import org.x96.sys.sc.ir.synthetic.Feedback;

public class EmitFeedback extends Emit<Feedback> {
    public EmitFeedback(Feedback t) {
        super(t);
    }

    @Override
    public String toSC() {
        return new EmitStimulus(t.stimulus()).toSC();
    }
}
