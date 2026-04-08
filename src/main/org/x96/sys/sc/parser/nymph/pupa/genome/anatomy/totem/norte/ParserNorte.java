package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.norte;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Norte;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast.Signature;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.ParserSignature;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.Optional;

public class ParserNorte extends Parser<Norte> {
    public ParserNorte(Tape tape) {
        super(tape);
    }

    @Override
    public Norte parse() {
        Primor primor = new ParserPrimor(tape).parse();
        skipI();

        Optional<Signature> signature = Optional.empty();
        if (hasNextSignature()) {
            signature = Optional.of(new ParserSignature(tape).parse());
            skipI();
        }

        return new Norte(primor, signature);
    }
}
