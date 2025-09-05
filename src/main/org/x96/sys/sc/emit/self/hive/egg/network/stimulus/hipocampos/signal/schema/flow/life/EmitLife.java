package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.flow.life;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.ir.synthetic.Life;

public class EmitLife extends Emit<Life> {
    public EmitLife(Life t) {
        super(t);
    }

    @Override
    public String toSC() {
        if (!t.state()){
            throw new RuntimeException("dead life can't be emitted");
        }
        return "0x0";
    }
}
