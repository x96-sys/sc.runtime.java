package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Gene;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Dendrite;

public class GeneToDendrite implements ToIr<Gene, Dendrite> {
    @Override
    public Dendrite convert(Gene gene) {
        return new Dendrite(new PairToNeurotransmitter().convert(gene.pair()));
    }
}
