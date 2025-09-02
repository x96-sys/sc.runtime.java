package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Id;

public class PrimorToId implements ToIr<Primor, Id> {

    @Override
    public Id convert(Primor primor) {
        return new Id(primor.raw());
    }
}
