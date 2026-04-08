package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Flower;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Nature;

public class FlowerToNature implements ToIr<Flower, Nature> {
    @Override
    public Nature convert(Flower flower) {
        return switch (flower) {
            case VARIABLE -> Nature.MUTABLE;
            case CONSTANT -> Nature.FIXED;
        };
    }
}
