package org.x96.sys.sc.emit.self.hive.egg.network.stimulus.hipocampos.signal.schema.neurotransmitter.isoform.formula;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.ir.synthetic.Formula;

public class EmitFormula extends Emit<Formula> {
    public EmitFormula(Formula t) {
        super(t);
    }

    @Override
    public String toSC() {
        return switch (t){
            case ARRAY -> "[]";
            case OPTIONAL -> "?";
        };
    }
}
