package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Nucleotide;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Spore;

public class NucleotideToSpore implements ToIr<Nucleotide, Spore> {
    @Override
    public Spore convert(Nucleotide nucleotide) {
        return new Spore(
                new PrimorToId().convert(nucleotide.primor()),
                new FlyToImpulse().convert(nucleotide.fly()));
    }
}
