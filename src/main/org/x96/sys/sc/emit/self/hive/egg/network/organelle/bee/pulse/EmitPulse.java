package org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.organelle.bee.pulse.feedback.EmitChemical;
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

        StringBuilder e = new StringBuilder();
        e.append(String.format(":ethics %s%s", id, schema));
        if (t.chemical().isEmpty()) {
            e.append(";\n");
        } else {
            e.append("\n");
            String chemical = new EmitChemical(t.chemical().get()).toSC();
            e.append(" ".repeat(4));
            e.append(" ".repeat(4));
            e.append(chemical);
            e.append("\n").append(" ".repeat(4));
            e.append(";");
        }
        return e.toString();
    }
}
