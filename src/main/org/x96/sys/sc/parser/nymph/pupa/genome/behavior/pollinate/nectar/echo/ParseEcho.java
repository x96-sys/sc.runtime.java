package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.echo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Echo;
import org.x96.sys.sc.parser.Parser;

import java.io.ByteArrayOutputStream;

public class ParseEcho extends Parser<Echo> {
    public ParseEcho(Tape tape) {
        super(tape);
    }

    @Override
    public Echo parse() {
        consume("echo"); // first [']
        ByteArrayOutputStream out = new ByteArrayOutputStream();
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
