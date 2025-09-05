package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.manifest;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Manifest;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.ParserBehavior;

public class ParserManifest extends Parser<Manifest> {
    public ParserManifest(Tape tape) {
        super(tape);
    }

    @Override
    public Manifest parse() {
        return new Manifest(new ParserBehavior(tape).parse());
    }
}
