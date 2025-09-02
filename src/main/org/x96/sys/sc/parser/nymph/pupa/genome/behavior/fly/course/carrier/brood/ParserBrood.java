package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier.brood;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Brood;
import org.x96.sys.sc.ast.synthetic.Nectar;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.ParserNectar;

import java.util.ArrayList;
import java.util.List;

public class ParserBrood extends Parser<Brood> {
    public ParserBrood(Tape tape) {
        super(tape);
    }

    @Override
    public Brood parse() {
        List<Nectar> nectar = new ArrayList<>();
        nectar.add(new ParserNectar(tape).parse());
        skipI();
        followNectar(nectar);
        return new Brood(nectar.toArray(Nectar[]::new));
    }

    private void followNectar(List<Nectar> nectar) {
        if (hasNext("nectar_follow")) {
            consume("nectar_follow");
            skipI();
            nectar.add(new ParserNectar(tape).parse());
            skipI();
            followNectar(nectar);
        }
    }
}
