package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.bug;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Bug;
import org.x96.sys.sc.ast.synthetic.Ethics;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.ParserEthics;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;

public class ParserBug extends Parser<Bug> {
    public ParserBug(Tape tape) {
        super(tape);
    }

    @Override
    public Bug parse() {
        skip("bug");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        List<Ethics> ethics = new ArrayList<>();
        followBugAnatomy(ethics);
        return new Bug(primor, ethics.toArray(Ethics[]::new));
    }

    private void followBugAnatomy(List<Ethics> ethics) {
        if (hasNext("init_anatomy")) {
            consume("init_anatomy");
            ethics.add(new ParserEthics(tape).parse());
            skipI();
            consume("fini_anatomy");
            skipI();
            followBugAnatomy(ethics);
        }
    }
}
