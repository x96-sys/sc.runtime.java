package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.ModSig;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Formula;

public class ModSigToFormula implements ToIr<ModSig, Formula> {
    @Override
    public Formula convert(ModSig modSig) {
        return switch (modSig) {
            case ARRAY -> Formula.ARRAY;
            case OPTIONAL -> Formula.OPTIONAL;
            case SPLAT -> Formula.SPLAT;
        };
    }
}
