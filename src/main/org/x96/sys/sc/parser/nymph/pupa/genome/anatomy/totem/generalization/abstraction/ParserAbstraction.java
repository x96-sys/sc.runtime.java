package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization.abstraction;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Abstraction;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast.Tie;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.can.ParserAs;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.can.ParserCan;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.Optional;

public class ParserAbstraction extends Parser<Abstraction> {
    public ParserAbstraction(Tape tape) {
        super(tape);
    }

    @Override
    public Abstraction parse() {
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        Optional<Tie> tie = Optional.empty();
        if (hasNextTie()) {
            if (hasNextCan()) {
                tie = Optional.of(new ParserCan(tape).parse());
            } else if (hasNextAs()) {
                tie = Optional.of(new ParserAs(tape).parse());
            }
        }
        return new Abstraction(primor, tie);
    }
}
