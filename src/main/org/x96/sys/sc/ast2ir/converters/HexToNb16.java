package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Hex;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Nb16;

public class HexToNb16 implements ToIr<Hex, Nb16> {
    @Override
    public Nb16 convert(Hex hex) {
        return new Nb16(hex.raw());
    }
}
