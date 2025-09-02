package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier.brood;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Brood;
import org.x96.sys.sc.parser.Parser;

import java.util.Optional;

public class ParserOptionalBrood extends Parser<Optional<Brood>> {
    public ParserOptionalBrood(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Brood> parse() {
        Optional<Brood> brood = Optional.empty();
        if (hasNextBrood()){
            brood = Optional.of(new ParserBrood(tape).parse());
        }
        return brood;
    }
}
