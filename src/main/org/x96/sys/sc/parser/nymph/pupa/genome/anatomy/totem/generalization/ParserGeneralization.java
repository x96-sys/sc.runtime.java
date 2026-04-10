package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Abstraction;
import org.x96.sys.sc.ast.Generalization;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization.abstraction.ParserAbstraction;

import java.util.ArrayList;
import java.util.List;

public class ParserGeneralization extends Parser<Generalization> {
    public ParserGeneralization(Tape tape) {
        super(tape);
    }

    @Override
    public Generalization parse() {
        consume("init_generalization");
        skipI();
        List<Abstraction> abstractions = new ArrayList<>();
        followAbstractions(abstractions);
        consume("fini_generalization");
        return new Generalization(abstractions.toArray(Abstraction[]::new));
    }

    private void followAbstractions(List<Abstraction> abstractions) {
        abstractions.add(new ParserAbstraction(tape).parse());
        skipI();
        if (hasNext("abstraction_follow")) {
            consume("abstraction_follow");
            skipI();
            followAbstractions(abstractions);
        }
    }
}
