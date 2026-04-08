package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.aura;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Aura;
import org.x96.sys.sc.ast.Resonance;
import org.x96.sys.sc.ast.Signature;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.ParserSignature;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.resonance.ParserOptionalResonance;

import java.util.Optional;

public class ParserAura extends Parser<Aura> {
    public ParserAura(Tape tape) {
        super(tape);
    }

    @Override
    public Aura parse() {
        Signature signature = new ParserSignature(tape).parse();
        skipI();
        Optional<Resonance> resonance = new ParserOptionalResonance(tape).parse();
        return new Aura(signature, resonance);
    }
}
