package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.manifest.ParserManifest;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.ParserSignature;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.resonance.ParserResonance;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.Optional;

public class ParserEthics extends Parser<Ethics> {
    public ParserEthics(Tape tape) {
        super(tape);
    }

    @Override
    public Ethics parse() {
        skip("ethics");
        skipI();

        Primor primor = new ParserPrimor(tape).parse();
        skipI();

        Optional<Signature> signature = Optional.empty();
        if (hasNextSignature()) {
            signature = Optional.of(new ParserSignature(tape).parse());
            skipI();
        }

        Optional<Resonance> resonance = Optional.empty();
        if (hasNextResonance()) {
            resonance = Optional.of(new ParserResonance(tape).parse());
            skipI();
        }

        Optional<Manifest> manifest = Optional.empty();
        if (hasNextBehavior()) {
            manifest = Optional.of(new ParserManifest(tape).parse());
        }

        return new Ethics(primor, signature, resonance, manifest);
    }
}
