package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course;

import org.x96.sys.parser.Tape;

import org.x96.sys.sc.ast.synthetic.Course;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier.ParserCarrier;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.catalysis.ParserCatalysis;

public class ParserCourse extends Parser<Course> {
    public ParserCourse(Tape tape) {
        super(tape);
    }

    @Override
    public Course parse() {
        if (hasNextCatalysis()) {
            return new ParserCatalysis(tape).parse();
        }
        if (hasNextCarrier()){
            return new ParserCarrier(tape).parse();
        }
        throw new RuntimeException("?");
    }
}
