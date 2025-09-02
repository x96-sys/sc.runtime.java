package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.catalysis;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Catalysis;
import org.x96.sys.sc.ast.synthetic.Course;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.ParserOptionalCourse;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.Optional;

public class ParserCatalysis extends Parser<Catalysis> {
    public ParserCatalysis(Tape tape) {
        super(tape);
    }

    @Override
    public Catalysis parse() {
        consume("catalysis"); // .
        Primor primor = new ParserPrimor(tape).parse();
        Optional<Course> course = new ParserOptionalCourse(tape).parse();
        return new Catalysis(primor, course);
    }
}
