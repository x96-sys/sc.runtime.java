package org.x96.sys.sc.parser.nymph.pupa;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Genome;
import org.x96.sys.sc.ast.synthetic.Pupa;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.ParserGenome;

import java.util.ArrayList;
import java.util.List;

public class ParserPupa extends Parser<Pupa> {
    public ParserPupa(Tape tape) {
        super(tape);
    }

    @Override
    public Pupa parse() {
        List<Genome> genome = new ArrayList<>();
        followGenome(genome);
        return new Pupa(genome.toArray(Genome[]::new));
    }

    private void followGenome(List<Genome> genome) {
        if (hasNextGenome()) {
            genome.add(new ParserGenome(tape).parse());
            skipI();
            followGenome(genome);
        }
    }
}
