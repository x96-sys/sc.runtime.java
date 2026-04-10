package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Nectar;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalNectar extends ParserOptional<Nectar> {
    public ParserOptionalNectar(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Nectar> parse() {
        Optional<Nectar> nectar = Optional.empty();
        if (hasNextNectar()) {
            nectar = Optional.of(new ParserNectar(tape).parse());
            skipI();
        }
        return nectar;
    }
}
