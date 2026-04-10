package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;

import java.io.ByteArrayOutputStream;

public class ParserPrimor extends Parser<Primor> {
    public ParserPrimor(Tape tape) {
        super(tape);
    }

    @Override
    public Primor parse() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        do {
            out.write(consume("primor").lexeme().b());
        } while (hasNext("primor"));
        return new Primor(out.toByteArray());
    }
}
