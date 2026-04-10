package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.can;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Can;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserCan extends Parser<Can> {
    public ParserCan(Tape tape) {
        super(tape);
    }

    @Override
    public Can parse() {
        skip("can");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        return new Can(primor);
    }
}
