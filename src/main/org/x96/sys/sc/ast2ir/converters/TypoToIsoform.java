package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Typo;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Isoform;

public class TypoToIsoform implements ToIr<Typo, Isoform> {
    @Override
    public Isoform convert(Typo typo) {
        return new Isoform(new PrimorToId().convert(typo.primor()));
    }
}
