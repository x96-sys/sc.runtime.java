package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager.echo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Echo;
import org.x96.sys.sc.parser.Parser;

import java.io.ByteArrayOutputStream;

public class ParserEcho extends Parser<Echo> {
    public ParserEcho(Tape tape) {
        super(tape);
    }

    @Override
    public Echo parse() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        consume("echo"); // first '
        followEcho(out);
        return new Echo(out.toByteArray());
    }

    private void followEcho(ByteArrayOutputStream out) {
        if (hasNext("echo")) {
            byte b = consume("echo").lexeme().b();
            if (hasNext("echo")) {
                out.write(b);
                followEcho(out);
            }
        }
    }
}
