package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Pair;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.AminoAcid;
import org.x96.sys.sc.ir.synthetic.Isoform;
import org.x96.sys.sc.ir.synthetic.Neurotransmitter;

import java.util.Optional;

public class PairToNeurotransmitter implements ToIr<Pair, Neurotransmitter> {
    @Override
    public Neurotransmitter convert(Pair pair) {

        Optional<AminoAcid> aminoacid = Optional.empty();
        if (pair.attribute().isPresent()) {
            aminoacid = Optional.of(new AttributeToAminoAcid().convert(pair.attribute().get()));
        }
        Isoform isoform = new TypoToIsoform().convert(pair.typo());
        return new Neurotransmitter(aminoacid, isoform);
    }
}
