package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.attribute;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Attribute;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserOptionalPrimor;

import java.util.Optional;

public class ParserAttribute extends Parser<Attribute> {
    public ParserAttribute(Tape tape) {
        super(tape);
    }

    @Override
    public Attribute parse() {
        boolean splat = false;
        if (hasNext("splat")) {
            consume("splat");
            splat = true;
        }
        Optional<Primor> primor = new ParserOptionalPrimor(tape).parse();
        return new Attribute(splat, primor);
    }
}
