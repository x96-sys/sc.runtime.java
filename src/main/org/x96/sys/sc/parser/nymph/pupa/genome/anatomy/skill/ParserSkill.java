package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.skill;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;

public class ParserSkill extends Parser<Skill> {
    public ParserSkill(Tape tape) {
        super(tape);
    }

    @Override
    public Skill parse() {
        skip("skill");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        List<Ethics> ethics = new ArrayList<>();
        List<Can> can = new ArrayList<>();
        List<As> as = new ArrayList<>();
        List<Gene> genes = new ArrayList<>();
        followBugAnatomy(ethics, can, as, genes);
        return new Skill(primor, ethics.toArray(Ethics[]::new));
    }
}
