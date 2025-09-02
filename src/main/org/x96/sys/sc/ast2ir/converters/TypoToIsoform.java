package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Typo;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Formula;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Isoform;

import java.util.Optional;

public class TypoToIsoform implements ToIr<Typo, Isoform> {
    @Override
    public Isoform convert(Typo typo) {
        Optional<Formula> formula = Optional.empty();
        if (typo.modTypo().isPresent()){
            formula = Optional.of(new ModTypoToFormula().convert(typo.modTypo().get()));
        }
        Id id = new PrimorToId().convert(typo.primor());
        return new Isoform(formula, id);
    }
}
