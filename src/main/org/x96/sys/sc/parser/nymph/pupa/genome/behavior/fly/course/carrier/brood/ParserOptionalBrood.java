package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier.brood;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Brood;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalBrood extends ParserOptional<Brood> {
    public ParserOptionalBrood(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Brood> parse() {
        Optional<Brood> brood = Optional.empty();
        if (hasNextBrood()) {
            brood = Optional.of(new ParserBrood(tape).parse());
        }
        return brood;
    }
}
