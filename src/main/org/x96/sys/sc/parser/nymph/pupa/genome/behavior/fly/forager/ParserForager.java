package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Forager;
import org.x96.sys.sc.ast.Ipse;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager.echo.ParserEcho;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.hex.ParserHex;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserForager extends Parser<Forager> {
    public ParserForager(Tape tape) {
        super(tape);
    }

    @Override
    public Forager parse() {
        if (hasNextPrimor()) {
            return new ParserPrimor(tape).parse();
        }
        if (hasNextIpse()) {
            return new Ipse(consume("ipse").lexeme().b());
        }
        if (hasNextHex()) {
            return new ParserHex(tape).parse();
        }
        if (hasNextEcho()) {
            return new ParserEcho(tape).parse();
        }
        System.out.println(tape.current().toString());
        throw new RuntimeException("me resolva " + tape.current().toString());
    }
}
