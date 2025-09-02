package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.resonance;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Resonance;
import org.x96.sys.sc.parser.Parser;

import java.util.Optional;

public class ParserOptionalResonance extends Parser<Optional<Resonance>> {
    public ParserOptionalResonance(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Resonance> parse() {
        if (hasNextResonance()) {
            return Optional.of(new ParserResonance(tape).parse());
        }

        return Optional.empty();
    }
}
