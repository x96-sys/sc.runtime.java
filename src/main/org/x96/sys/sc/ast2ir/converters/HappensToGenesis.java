package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Happens;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Genesis;
import org.x96.sys.sc.ir.Spore;

public class HappensToGenesis implements ToIr<Happens, Genesis> {
    @Override
    public Genesis convert(Happens happens) {
        Spore[] spores = new Spore[happens.nucleotides().length];
        for (int i = 0; i < happens.nucleotides().length; i++) {
            spores[i] = new NucleotideToSpore().convert(happens.nucleotides()[i]);
        }
        return new Genesis(spores);
    }
}
