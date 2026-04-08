package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Pair;
import org.x96.sys.sc.ast.Signature;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.ParserPair;

import java.util.ArrayList;
import java.util.List;

public class ParserSignature extends Parser<Signature> {
    public ParserSignature(Tape tape) {
        super(tape);
    }

    @Override
    public Signature parse() {
        List<Pair> pairs = new ArrayList<>();
        consume("init_signature"); // {
        pairs.add(new ParserPair(tape).parse());
        followPairs(pairs);
        consume("fini_signature"); // }
        return new Signature(pairs.toArray(Pair[]::new));
    }

    private void followPairs(List<Pair> pairs) {
        if (hasNextPairFollow()) {
            consume("pair_follow"); // ,
            pairs.add(new ParserPair(tape).parse());
            followPairs(pairs);
        }
    }
}
