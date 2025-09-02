package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.resonance;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Ready;
import org.x96.sys.sc.ast.synthetic.Resonance;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserResonance extends Parser<Resonance> {
    public ParserResonance(Tape tape) {
        super(tape);
    }


    @Override
    public Resonance parse() {
        if (hasNextVoid()) {
            consume("void"); // 0
            consume("void"); // x
            consume("void"); // 0
            return new Ready(true);
        }
        if (hasNextPrimor()) {
            return new ParserPrimor(tape).parse();
        }
        throw new RuntimeException("?");
    }
}
