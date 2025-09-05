package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Forager;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserForager extends Parser<Forager> {
    public ParserForager(Tape tape) {
        super(tape);
    }

    @Override
    public Forager parse() {
        boolean self = false;
        Primor primor = null;
        if (hasNextPrimor()) {
            primor = new ParserPrimor(tape).parse();
        }
        if (hasNextSelf()){
            byte[] payload = new byte[]{consume("self").lexeme().b()};
            primor= new Primor(payload);
            self = true;
        }
        return new Forager(self, primor);
    }
}
