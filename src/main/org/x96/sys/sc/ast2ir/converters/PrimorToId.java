package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Id;

public class PrimorToId implements ToIr<Primor, Id> {

    @Override
    public Id convert(Primor primor) {
        return new Id(primor.raw());
    }
}
