package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.As;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Be;

public class AsToBe implements ToIr<As, Be> {
    @Override
    public Be convert(As as) {
        return new Be(new PrimorToId().convert(as.primor()));
    }
}
