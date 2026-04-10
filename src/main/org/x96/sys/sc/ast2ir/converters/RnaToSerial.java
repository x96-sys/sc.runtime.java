package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Echo;
import org.x96.sys.sc.ast.Norte;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast.Rna;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Serial;

public class RnaToSerial implements ToIr<Rna, Serial> {
    @Override
    public Serial convert(Rna rna) {
        return switch (rna) {
            case Echo echo -> new EchoToText().convert(echo);
            case Norte norte -> new NorteToDirection().convert(norte);
            case Primor primor -> new PrimorToId().convert(primor);
        };
    }
}
