package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Know;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Connect;

public class KnowToConnect implements ToIr<Know, Connect> {
    @Override
    public Connect convert(Know know) {
        return new Connect(new PrimorToId().convert(know.primor()));
    }
}
