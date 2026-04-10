package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.resonance;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Resonance;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalResonance extends ParserOptional<Resonance> {
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
