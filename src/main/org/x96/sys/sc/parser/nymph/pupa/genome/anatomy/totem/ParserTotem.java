package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Ethics;
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
        skip("totem");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        List<Primor> primes = new ArrayList<>();
        List<Ethics> ethics = new ArrayList<>();
        followTotemContent(primes, ethics);
        return new Totem(primor, primes.toArray(Primor[]::new), ethics.toArray(Ethics[]::new));
    }

    private void followTotemContent(List<Primor> primes, List<Ethics> ethics) {
        if (hasNextPrimor()) {
            primes.add(new ParserPrimor(tape).parse());
            skipI();
            followTotemContent(primes, ethics);
        }

    }
}
