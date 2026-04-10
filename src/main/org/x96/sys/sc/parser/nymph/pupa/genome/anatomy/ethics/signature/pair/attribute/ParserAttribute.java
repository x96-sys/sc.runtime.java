package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.attribute;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Attribute;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserOptionalPrimor;

import java.util.Optional;

public class ParserAttribute extends Parser<Attribute> {
    public ParserAttribute(Tape tape) {
        super(tape);
    }

    @Override
    public Attribute parse() {
        Optional<Primor> primor = new ParserOptionalPrimor(tape).parse();
        return new Attribute(primor);
    }
}
