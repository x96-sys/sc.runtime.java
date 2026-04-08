package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.As;
import org.x96.sys.sc.ast.Can;
import org.x96.sys.sc.ast.Tie;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Bond;

public class TieToBond implements ToIr<Tie, Bond> {
    @Override
    public Bond convert(Tie tie) {
        return switch (tie) {
            case As as -> new AsToBe().convert(as);
            case Can can -> new CanToAble().convert(can);
        };
    }
}
