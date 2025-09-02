package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Brood;
import org.x96.sys.sc.ast.synthetic.Carrier;
import org.x96.sys.sc.ast.synthetic.Course;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.ParserOptionalCourse;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier.brood.ParserOptionalBrood;

import java.util.Optional;

public class ParserCarrier extends Parser<Carrier> {
    public ParserCarrier(Tape tape) {
        super(tape);
    }

    @Override
    public Carrier parse() {
        consume("init_carrier");
        skipI();
        Optional<Brood> brood = new ParserOptionalBrood(tape).parse();
        consume("fini_carrier");
        Optional<Course> course = new ParserOptionalCourse(tape).parse();
        return new Carrier(brood, course);
    }
}
