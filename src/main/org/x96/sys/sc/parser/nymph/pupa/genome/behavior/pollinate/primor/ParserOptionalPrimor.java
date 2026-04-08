package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalPrimor extends ParserOptional<Primor> {
    public ParserOptionalPrimor(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Primor> parse() {
        if (hasNextPrimor()) {
            return Optional.of(new ParserPrimor(tape).parse());
        }
        return Optional.empty();
    }
}
