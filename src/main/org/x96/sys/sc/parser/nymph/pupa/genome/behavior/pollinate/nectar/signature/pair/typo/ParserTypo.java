package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.typo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.ModTypo;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.ast.synthetic.Typo;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.typo.modTypo.ParserOptionalModTypo;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.Optional;

public class ParserTypo extends Parser<Typo> {
    public ParserTypo(Tape tape) {
        super(tape);
    }

    @Override
    public Typo parse() {
        consume("typo"); // :
        skipI();
        Optional<ModTypo> modTypo = new ParserOptionalModTypo(tape).parse();
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        return new Typo(modTypo, primor);
    }
}
