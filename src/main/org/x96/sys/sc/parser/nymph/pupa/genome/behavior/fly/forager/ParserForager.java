package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Forager;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserForager extends Parser<Forager> {
    public ParserForager(Tape tape) {
        super(tape);
    }

    @Override
    public Forager parse() {
        return new Forager(new ParserPrimor(tape).parse());
    }
}
