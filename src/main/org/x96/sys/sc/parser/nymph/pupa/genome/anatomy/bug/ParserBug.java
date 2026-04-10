package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.bug;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization.ParserOptionalGeneralization;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserBug extends Parser<Bug> {
    public ParserBug(Tape tape) {
        super(tape);
    }

    @Override
    public Bug parse() {
        skip("bug");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        Optional<Generalization> generalization = new ParserOptionalGeneralization(tape).parse();
        skipI();
        List<Ethics> ethics = new ArrayList<>();
        List<Can> can = new ArrayList<>();
        List<As> as = new ArrayList<>();
        List<Gene> genes = new ArrayList<>();
        followBugAnatomy(ethics, can, as, genes);
        return new Bug(
                primor,
                genes.toArray(Gene[]::new),
                ethics.toArray(Ethics[]::new),
                can.toArray(Can[]::new),
                as.toArray(As[]::new),
                generalization);
    }
}
