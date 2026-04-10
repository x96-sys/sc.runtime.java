package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.can;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.As;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserAs extends Parser<As> {
    public ParserAs(Tape tape) {
        super(tape);
    }

    @Override
    public As parse() {
        skip("as");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        return new As(primor);
    }
}
