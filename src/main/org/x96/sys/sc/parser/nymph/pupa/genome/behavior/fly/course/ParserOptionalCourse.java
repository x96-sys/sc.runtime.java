package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Course;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalCourse extends ParserOptional<Course> {
    public ParserOptionalCourse(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Course> parse() {
        Optional<Course> c = Optional.empty();
        if (hasNextCourse()) {
            c = Optional.of(new ParserCourse(tape).parse());
        }
        return c;
    }
}
