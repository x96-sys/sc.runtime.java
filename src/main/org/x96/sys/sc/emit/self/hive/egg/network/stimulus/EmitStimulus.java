package org.x96.sys.sc.emit.self.hive.egg.network.stimulus;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.EmitHipocampos;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.impulse.EmitImpulse;
import org.x96.sys.sc.ir.synthetic.Hipocampos;
import org.x96.sys.sc.ir.synthetic.Impulse;
import org.x96.sys.sc.ir.synthetic.Stimulus;

public class EmitStimulus extends Emit<Stimulus> {
    public EmitStimulus(Stimulus stimulus) {
        super(stimulus);
    }
    @Override
    public String toSC() {
        return switch (t) {
            case Hipocampos hipocampos -> new EmitHipocampos(hipocampos).toSC();
            case Impulse impulse -> new EmitImpulse(impulse).toSC();
        };
    }
}
