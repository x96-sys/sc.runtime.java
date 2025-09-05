package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Anatomy;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.bug.ParserBug;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.ParserTotem;

public class ParserAnatomy extends Parser<Anatomy> {
    public ParserAnatomy(Tape tape) {
        super(tape);
    }

    @Override
    public Anatomy parse() {
        Anatomy anatomy = null;
        consume("init_anatomy");
        skipI();
        if (hasNext("totem")) {
            anatomy = new ParserTotem(tape).parse();
            skipI();
        }
        if (hasNext("bug")) {
             anatomy = new ParserBug(tape).parse();
             skipI();
        }
        consume("fini_anatomy");
        skipI();
        return anatomy;
    }
}
