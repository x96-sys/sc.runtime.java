package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.ast.synthetic.Totem;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;

public class ParserTotem extends Parser<Totem> {
    public ParserTotem(Tape tape) {
        super(tape);
    }

    @Override
    public Totem parse() {
        for (int i = 0; i < 5; i++) {
            consume("totem");
        }
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        List<Primor> primes = new ArrayList<>();
        followPrimor(primes);
        return new Totem(primor, primes.toArray(Primor[]::new));
    }

    private void followPrimor(List<Primor> primes) {
        if (hasNext("primor")) {
            primes.add(new ParserPrimor(tape).parse());
            skipI();
            followPrimor(primes);
        }
    }
}
