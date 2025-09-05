package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.flow;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.flow.life.EmitLife;
import org.x96.sys.sc.ir.synthetic.Flow;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Life;

public class EmitFlow extends Emit<Flow> {
    public EmitFlow(Flow t) {
        super(t);
    }

    @Override
    public String toSC() {
        return switch (t) {
            case Id id -> new EmitId(id).toSC();
            case Life life -> new EmitLife(life).toSC();
        };
    }
}
