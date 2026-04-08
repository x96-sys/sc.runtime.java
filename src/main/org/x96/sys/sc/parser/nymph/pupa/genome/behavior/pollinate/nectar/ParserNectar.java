package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Brood;
import org.x96.sys.sc.ast.Nectar;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.ParserFly;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.course.carrier.brood.ParserBrood;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.aura.ParserAura;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.filament.ParserFilament;

public class ParserNectar extends Parser<Nectar> {
    public ParserNectar(Tape tape) {
        super(tape);
    }

    @Override
    public Nectar parse() {
        if (hasNextNectar()) {
            if (hasNextSignature()) {
                return new ParserAura(tape).parse();
            }

            if (hasNextFly()) {
                return new ParserFly(tape).parse();
            }

            if (hasNextFilament()) {
                return new ParserFilament(tape).parse();
            }

            if (hasNextBrood()) {
                return new ParserBrood(tape).parse();
            }

            System.out.println(tape.current().toString());
            throw new RuntimeException("como tratar?");
        }
        if (hasNext("init_array")) {
            consume("init_array");
            skipI();
            Brood brood = new ParserBrood(tape).parse();
            skipI();
            consume("fini_array");
            skipI();
            return brood;
        }

        System.out.println(tape.current().toString());
        throw new RuntimeException("Nectar not found");
    }
}
