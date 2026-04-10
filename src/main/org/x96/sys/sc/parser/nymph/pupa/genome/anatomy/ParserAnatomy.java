package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Anatomy;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.bug.ParserBug;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.ParserEthics;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.know.ParserKnow;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.logos.ParserLogos;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.skill.ParserSkill;
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
        if (hasNextTotem()) {
            anatomy = new ParserTotem(tape).parse();
            skipI();
        }
        if (hasNextBug()) {
            anatomy = new ParserBug(tape).parse();
            skipI();
        }
        if (hasNextSkill()) {
            anatomy = new ParserSkill(tape).parse();
            skipI();
        }
        if (hasNextLogos()) {
            anatomy = new ParserLogos(tape).parse();
            skipI();
        }
        if (hasNextKnow()) {
            anatomy = new ParserKnow(tape).parse();
            skipI();
        }
        if (hasNext("ethics")) {
            anatomy = new ParserEthics(tape).parse();
            skipI();
        }
        consume("fini_anatomy");
        skipI();
        return anatomy;
    }
}
