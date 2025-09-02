package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.ModTypo;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Formula;

public class ModTypoToFormula implements ToIr<ModTypo, Formula> {
    @Override
    public Formula convert(ModTypo modTypo) {
        return switch (modTypo) {
            case ARRAY    -> Formula.ARRAY;
            case OPTIONAL -> Formula.OPTIONAL;
        };
    }
}
