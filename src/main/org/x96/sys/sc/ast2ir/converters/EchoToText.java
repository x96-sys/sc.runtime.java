package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Echo;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Text;

public class EchoToText implements ToIr<Echo, Text> {
    @Override
    public Text convert(Echo ast) {
        return new Text(ast.raw());
    }
}
