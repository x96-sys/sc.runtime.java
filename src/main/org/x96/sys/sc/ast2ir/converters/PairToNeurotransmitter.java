package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Pair;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.AminoAcid;
import org.x96.sys.sc.ir.Formula;
import org.x96.sys.sc.ir.Isoform;
import org.x96.sys.sc.ir.Neurotransmitter;

import java.util.Optional;

public class PairToNeurotransmitter implements ToIr<Pair, Neurotransmitter> {
    @Override
    public Neurotransmitter convert(Pair pair) {

        Formula[] formulas = new Formula[pair.modSigs().length];
        for (int i = 0; i < pair.modSigs().length; i++) {
            formulas[i] = new ModSigToFormula().convert(pair.modSigs()[i]);
        }

        Optional<AminoAcid> aminoacid = Optional.empty();
        if (pair.attribute().isPresent()) {
            aminoacid = Optional.of(new AttributeToAminoAcid().convert(pair.attribute().get()));
        }
        Isoform isoform = new TypoToIsoform().convert(pair.typo());
        return new Neurotransmitter(formulas, aminoacid, isoform);
    }
}
