package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.manifest;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Behavior;
import org.x96.sys.sc.ast.Manifest;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.ParserBehavior;

import java.util.ArrayList;
import java.util.List;

public class ParserManifest extends Parser<Manifest> {
    public ParserManifest(Tape tape) {
        super(tape);
    }

    @Override
    public Manifest parse() {
        List<Behavior> behaviors = new ArrayList<>();
        followBehavior(behaviors);
        return new Manifest(behaviors.toArray(Behavior[]::new));
    }

    private void followBehavior(List<Behavior> behaviors) {
        if (hasNextBehavior()) {
            behaviors.add(new ParserBehavior(tape).parse());
            skipI();
            followBehavior(behaviors);
        }
    }
}
