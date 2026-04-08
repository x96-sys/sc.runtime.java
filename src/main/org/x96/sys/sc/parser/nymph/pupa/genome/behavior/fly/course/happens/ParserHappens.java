package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.happens;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Fly;
import org.x96.sys.sc.ast.Happens;
import org.x96.sys.sc.ast.Nucleotide;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.ParserFly;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;

public class ParserHappens extends Parser<Happens> {

    public ParserHappens(Tape tape) {
        super(tape);
    }

    @Override
    public Happens parse() {
        consume("init_happens");
        List<Nucleotide> nucleotides = new ArrayList<>();
        followNucleotides(nucleotides);
        consume("fini_happens");
        return new Happens(nucleotides.toArray(Nucleotide[]::new));
    }

    private void followNucleotides(List<Nucleotide> nucleotides) {
        Primor parse = new ParserPrimor(tape).parse();
        skipI();
        consume("nucleotide"); // :
        skipI();
        Fly fly = new ParserFly(tape).parse();
        nucleotides.add(new Nucleotide(parse, fly));
        skipI();
        if (hasNext("nucleotides_follow")) {
            consume("nucleotides_follow");
            followNucleotides(nucleotides);
        }
    }
}
