package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.isoform;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.id.EmitId;
import org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.isoform.formula.EmitFormula;
import org.x96.sys.sc.ir.synthetic.Isoform;

public class EmitIsoform extends Emit<Isoform> {
    public EmitIsoform(Isoform t) {
        super(t);
    }


    @Override
    public String toSC() {
        String formula = t.formula().map(f -> new EmitFormula(f).toSC()).orElse("");
        String id = new EmitId(t.id()).toSC();
        return String.format("%s%s", formula, id);
    }
}
