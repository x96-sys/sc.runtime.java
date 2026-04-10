package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.logos;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Logos;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserLogos extends Parser<Logos> {
    public ParserLogos(Tape tape) {
        super(tape);
    }

    @Override
    public Logos parse() {
        skip("logos");
        skipI();
        StringBuilder pkg = new StringBuilder();
        followPrimor(pkg);
        return new Logos(new Primor(pkg.toString().getBytes()));
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
