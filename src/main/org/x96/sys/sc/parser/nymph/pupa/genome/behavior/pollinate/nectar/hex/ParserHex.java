package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.hex;

import org.x96.sys.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.cs.parser.book.passage.pattern.core.hexadecimal.ParserHexadecimal;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Hex;
import org.x96.sys.sc.parser.Parser;

public class ParserHex extends Parser<Hex> {
    public ParserHex(Tape tape) {
        super(tape);
    }

    @Override
    public Hex parse() {
        String k = "hex";
        StringBuilder sb = new StringBuilder();
        consume(k); // 0
        consume(k); // x

        while (hasNext(k)) {
            sb.append((char) consume(k).lexeme().b());
        }

        return new Hex(Integer.parseInt(sb.toString(), 16));
    }
}
