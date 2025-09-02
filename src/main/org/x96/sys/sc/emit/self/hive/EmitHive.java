package org.x96.sys.sc.emit.self.hive;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.EmitEgg;
import org.x96.sys.sc.ir.synthetic.Hive;

public class EmitHive extends Emit<Hive> {
    public EmitHive(Hive hive) {
        super(hive);
    }

    @Override
    public String toSC() {
        return new EmitEgg(t.egg()).toSC();
    }
}
