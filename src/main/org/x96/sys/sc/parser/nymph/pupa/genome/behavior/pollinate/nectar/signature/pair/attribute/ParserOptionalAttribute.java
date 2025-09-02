package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.attribute;

import org.x96.sys.parser.Tape;

import org.x96.sys.sc.ast.synthetic.Attribute;
import org.x96.sys.sc.parser.Parser;

import java.util.Optional;

public class ParserOptionalAttribute extends Parser<Optional<Attribute>> {
    public ParserOptionalAttribute(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Attribute> parse() {
        Optional<Attribute> attribute = Optional.empty();
        if (hasNextAttribute()) {
            attribute = Optional.of(new ParserAttribute(tape).parse());
        }
        return attribute;
    }
}
