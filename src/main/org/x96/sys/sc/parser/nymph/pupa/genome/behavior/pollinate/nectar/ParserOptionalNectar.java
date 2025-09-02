package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Nectar;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.ParserSignature;

import java.util.Optional;

public class ParserOptionalNectar extends Parser<Optional<Nectar>> {
    public ParserOptionalNectar(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Nectar> parse() {
        Optional<Nectar> nectar = Optional.empty();
        if (hasNextNectar()){
            nectar = Optional.of(new ParserNectar(tape).parse());
            skipI();
        }
        if (hasNextSignature()) {
            nectar =  Optional.of(new ParserSignature(tape).parse());
            skipI();
        }
        return nectar;
    }
}
