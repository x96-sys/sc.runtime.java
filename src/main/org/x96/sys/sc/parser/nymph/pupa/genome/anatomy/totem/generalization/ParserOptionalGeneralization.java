package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Generalization;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalGeneralization extends ParserOptional<Generalization> {
    public ParserOptionalGeneralization(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Generalization> parse() {
        if (!hasNextGeneralization()) {
            return Optional.empty();
        }
        return Optional.of(new ParserGeneralization(tape).parse());
    }
}
