package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Course;
import org.x96.sys.sc.ast.Fly;
import org.x96.sys.sc.ast.Forager;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.ParserOptionalCourse;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager.ParserForager;

import java.util.Optional;

public class ParserFly extends Parser<Fly> {
    public ParserFly(Tape tape) {
        super(tape);
    }

    @Override
    public Fly parse() {
        Forager forager = new ParserForager(tape).parse();
        Optional<Course> course = new ParserOptionalCourse(tape).parse();
        return new Fly(forager, course);
    }
}
