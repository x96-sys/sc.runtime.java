package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.nature;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.ir.synthetic.Nature;

public class EmitNature extends Emit<Nature> {
    public EmitNature(Nature nature) {
        super(nature);
    }

    @Override
    public String toSC() {
        return switch (t){
            case MUTABLE -> "@";
            case STATIC -> "%";
        };
    }
}
