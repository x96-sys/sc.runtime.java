package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.nb16;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.ir.synthetic.Nb16;

public class EmitNb16 extends Emit<Nb16> {
    public EmitNb16(Nb16 t) {
        super(t);
    }

    @Override
    public String toSC() {
        return String.format("%X", t.raw());
    }
}
