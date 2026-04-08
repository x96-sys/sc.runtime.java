package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Can;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Able;

public class CanToAble implements ToIr<Can, Able> {
    @Override
    public Able convert(Can ast) {
        return new Able(new PrimorToId().convert(ast.primor()));
    }
}
