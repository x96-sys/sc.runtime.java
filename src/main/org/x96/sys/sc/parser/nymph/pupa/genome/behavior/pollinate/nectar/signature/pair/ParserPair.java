package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Attribute;
import org.x96.sys.sc.ast.synthetic.Pair;
import org.x96.sys.sc.ast.synthetic.Typo;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.ParserOptionalNectar;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.attribute.ParserOptionalAttribute;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.typo.ParserTypo;

import java.util.Optional;

public class ParserPair extends Parser<Pair> {
    public ParserPair(Tape tape) {
        super(tape);
    }

    @Override
    public Pair parse() {
        Optional<Attribute> attribute = new ParserOptionalAttribute(tape).parse();
        skipI();
        Typo typo = new ParserTypo(tape).parse();
        skipI();
        return new Pair(attribute, typo);
    }
}
