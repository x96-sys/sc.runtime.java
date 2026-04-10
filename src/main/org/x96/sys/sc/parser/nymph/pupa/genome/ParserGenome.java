package org.x96.sys.sc.parser.nymph.pupa.genome;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Genome;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ParserAnatomy;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.ParserBehavior;

public class ParserGenome extends Parser<Genome> {
    public ParserGenome(Tape tape) {
        super(tape);
    }

    @Override
    public Genome parse() {
        if (hasNextGenome()) {
            if (hasNextAnatomy()) {
                return new ParserAnatomy(tape).parse();
            } else if (hasNextBehavior()) {
                return new ParserBehavior(tape).parse();
            }
        }
        throw new RuntimeException("n ha o que ser parseado");
    }
}
