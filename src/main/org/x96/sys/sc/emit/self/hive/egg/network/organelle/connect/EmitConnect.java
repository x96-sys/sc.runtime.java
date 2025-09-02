package org.x96.sys.sc.emit.self.hive.egg.network.organelle.connect;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.Connect;

public class EmitConnect extends Emit<Connect> {
    public EmitConnect(Connect t) {
        super(t);
    }

    @Override
    public String toSC() {
        return String.format(":know '%s'%n", new EmitId(t.id()).toSC());
    }
}
