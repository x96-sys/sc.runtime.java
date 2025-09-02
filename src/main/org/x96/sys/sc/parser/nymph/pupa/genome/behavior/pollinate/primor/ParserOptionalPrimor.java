package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.ast.synthetic.Primor;

import java.util.Optional;

public class ParserOptionalPrimor extends Parser<Optional<Primor>> {
    public ParserOptionalPrimor(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<org.x96.sys.sc.ast.synthetic.Primor> parse() {
        if (hasNextPrimor()) {
            return Optional.of(new ParserPrimor(tape).parse());
        }
        return Optional.empty();
    }
}
