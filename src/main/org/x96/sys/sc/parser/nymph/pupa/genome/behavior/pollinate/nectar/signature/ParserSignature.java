package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Pair;
import org.x96.sys.sc.ast.synthetic.Resonance;
import org.x96.sys.sc.ast.synthetic.Signature;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.ParserPair;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.resonance.ParserOptionalResonance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserSignature extends Parser<Signature> {
    public ParserSignature(Tape tape) {
        super(tape);
    }

    @Override
    public Signature parse() {
        consume("init_signature"); // {
        skipI();
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new ParserPair(tape).parse());
        followPairs(pairs);
        consume("fini_signature"); // }
        skipI();
        Optional<Resonance> resonance = new ParserOptionalResonance(tape).parse();
        skipI();
        return new Signature(pairs.toArray(Pair[]::new), resonance);
    }

    private void followPairs(List<Pair> pairs) {
        if (hasNextPairFollow()) {
            consume("pair_follow"); // ,
            skipI();
            pairs.add(new ParserPair(tape).parse());
            followPairs(pairs);
        }

    }
}
