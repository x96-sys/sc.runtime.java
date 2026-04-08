package org.x96.sys.sc.parser.nymph;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Nymph;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.ParserPupa;

public class ParserNymph extends Parser<Nymph> {
    public ParserNymph(Tape tape) {
        super(tape);
    }

    @Override
    public Nymph parse() {
        return new Nymph(new ParserPupa(tape).parse());
    }
}
