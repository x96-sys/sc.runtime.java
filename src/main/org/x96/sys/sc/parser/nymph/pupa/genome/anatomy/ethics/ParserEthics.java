package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Ethics;
import org.x96.sys.sc.ast.synthetic.Manifest;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.ast.synthetic.Signature;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.manifest.ParserManifest;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.ParserBehavior;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.ParserSignature;
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
        Optional<Signature> signature = Optional.empty();
        if (hasNextSignature()) {
            signature =  Optional.of(new ParserSignature(tape).parse());
            skipI();
        }
        Optional<Manifest> manifest = Optional.empty();
        if (hasNextBehavior()) {
            manifest = Optional.of(new ParserManifest(tape).parse());
        }
        return new Ethics(primor, signature, manifest);
    }
}
