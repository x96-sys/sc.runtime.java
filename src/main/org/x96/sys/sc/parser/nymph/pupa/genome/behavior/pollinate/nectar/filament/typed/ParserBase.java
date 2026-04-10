package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.filament.typed;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Base;
import org.x96.sys.sc.parser.Parser;

public class ParserBase extends Parser<Base> {
    public ParserBase(Tape tape) {
        super(tape);
    }

    @Override
    public Base parse() {
        if (hasNext("lp")) {
            consume("lp"); // p
            return Base.PRIMOR;
        }
        consume("xexexe");
        return null;
    }
}
