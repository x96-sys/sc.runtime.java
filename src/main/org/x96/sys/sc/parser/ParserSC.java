package org.x96.sys.sc.parser;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Nymph;
import org.x96.sys.sc.ast.Sc;
import org.x96.sys.sc.parser.nymph.ParserNymph;

public class ParserSC extends Parser<Sc> {

    public ParserSC(Tape arg0) {
        super(arg0);
    }

    @Override
    public Sc parse() {
        consume("stx");
        Nymph nymph = new ParserNymph(tape).parse();
        consume("etx");
        return new Sc(nymph);
    }
}
