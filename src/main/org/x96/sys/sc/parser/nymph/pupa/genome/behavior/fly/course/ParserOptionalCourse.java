package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Course;
import org.x96.sys.sc.parser.Parser;

import java.util.Optional;

public class ParserOptionalCourse extends Parser<Optional<Course>> {
    public ParserOptionalCourse(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Course> parse() {
        Optional<Course> c = Optional.empty();
        if (hasNextCourse()){
            c = Optional.of(new ParserCourse(tape).parse());
        }
        return c;
    }
}
