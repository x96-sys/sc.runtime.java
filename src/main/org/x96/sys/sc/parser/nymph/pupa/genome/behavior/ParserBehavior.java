package org.x96.sys.sc.parser.nymph.pupa.genome.behavior;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Behavior;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.ParserFly;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.ParserPollinate;

public class ParserBehavior extends Parser<Behavior> {
    public ParserBehavior(Tape tape) {
        super(tape);
    }

    @Override
    public Behavior parse() {
        if (hasNextBehavior()) {
            if (hasNextPollinate()) {
                return new ParserPollinate(tape).parse();
            } else if (hasNextFly()) {
                return new ParserFly(tape).parse();
            } else {
                throw new RuntimeException("x");
            }
        }
        throw new RuntimeException("y");
    }
}
