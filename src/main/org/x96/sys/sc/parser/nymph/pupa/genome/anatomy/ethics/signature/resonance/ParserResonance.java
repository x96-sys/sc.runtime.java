package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.resonance;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Ready;
import org.x96.sys.sc.ast.Resonance;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization.ParserGeneralization;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserResonance extends Parser<Resonance> {
    public ParserResonance(Tape tape) {
        super(tape);
    }

    @Override
    public Resonance parse() {
        consume("resonance"); // !
        skipI();
        if (hasNextVoid()) {
            consume("void");
            return new Ready(true);
        }
        if (hasNextPrimor()) {
            return new ParserPrimor(tape).parse();
        }
        if (hasNextGeneralization()) {
            return new ParserGeneralization(tape).parse();
        }
        throw new RuntimeException("?");
    }
}
