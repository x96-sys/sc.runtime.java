package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.know;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Know;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserKnow extends Parser<Know> {
    public ParserKnow(Tape tape) {
        super(tape);
    }

    @Override
    public Know parse() {
        skip("know");
        skipI();
        StringBuilder pkg = new StringBuilder();
        followPrimor(pkg);
        return new Know(new Primor(pkg.toString().getBytes()));
    }

    private void followPrimor(StringBuilder sb) {
        if (hasNextPrimor()) {
            Primor primor = new ParserPrimor(tape).parse();
            sb.append(new String(primor.raw()));
            if (hasNext("web_follow")) {
                consume("web_follow");
                sb.append(".");
                followPrimor(sb);
            }
        }
    }
}
