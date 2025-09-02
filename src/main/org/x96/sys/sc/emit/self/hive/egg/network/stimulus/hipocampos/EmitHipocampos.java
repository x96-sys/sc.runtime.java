package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.nature.EmitNature;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.EmitSignal;
import org.x96.sys.sc.ir.synthetic.Hipocampos;

public class EmitHipocampos extends Emit<Hipocampos> {
    public EmitHipocampos(Hipocampos hipocampos) {
        super(hipocampos);
    }
    @Override
    public String toSC() {
        String nature = new EmitNature(t.nature()).toSC();
        String id = new EmitId(t.id()).toSC();
        String signal = t.signal().map(s -> new EmitSignal(s).toSC()).orElse("");
        return String.format("%s%s = %s%n", nature, id, signal);
    }
}
