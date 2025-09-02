package org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.feedback.EmitFeedback;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.EmitSchema;
import org.x96.sys.sc.ir.synthetic.Pulse;

public class EmitPulse extends Emit<Pulse> {
    public EmitPulse(Pulse t) {
        super(t);
    }

    @Override
    public String toSC() {
        String id = new EmitId(t.id()).toSC();
        String schema = t.schema().map(s -> new EmitSchema(s).toSC()).orElse("");
        String feedback = t.feedback().map(f -> new EmitFeedback(f).toSC()).orElse("");
        return String.format("%s%s%s", id, schema, feedback);
    }
}
