package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.serie;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Serie;

public class EmitSerie extends Emit<Serie> {
    public EmitSerie(Serie t) {
        super(t);
    }

    @Override
    public String toSC() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < t.ids().length; i++) {
            sb.append(new EmitId(t.ids()[i]).toSC());
            if (i < t.ids().length - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
