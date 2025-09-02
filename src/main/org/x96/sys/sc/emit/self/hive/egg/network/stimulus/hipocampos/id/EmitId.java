package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.ir.synthetic.Id;

public class EmitId extends Emit<Id> {
    public EmitId(Id id) {
        super(id);
    }

    @Override
    public String toSC() {
        return new String(t.raw());
    }
}
