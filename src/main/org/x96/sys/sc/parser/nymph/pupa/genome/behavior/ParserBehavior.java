package org.x96.sys.sc.parser.nymph.pupa.genome.behavior;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Behavior;
import org.x96.sys.sc.ast.synthetic.Pollinate;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.ParserFly;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.ParserPollinate;

public class ParserBehavior extends Parser<Behavior> {
    public ParserBehavior(Tape tape) {
        super(tape);
    }

    @Override
    public Behavior parse() {
        if (hasNextPollinate()) {
            Pollinate pollinate = new ParserPollinate(tape).parse();
            skipI();
            return pollinate;
        }
        if (hasNextFly()){
            return new ParserFly(tape).parse();
        }
        throw new RuntimeException("?");
    }
}
