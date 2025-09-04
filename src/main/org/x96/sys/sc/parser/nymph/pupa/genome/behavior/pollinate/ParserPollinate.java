package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.*;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.flower.ParserFlower;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.ParserOptionalNectar;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.Optional;

public class ParserPollinate extends Parser<Pollinate> {
    public ParserPollinate(Tape tape) {
        super(tape);
    }

    @Override
    public Pollinate parse() {
        Flower flower = new ParserFlower(tape).parse();
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        consume("pollinate"); // [=]
        skipI();
        Optional<Nectar> nectar = new ParserOptionalNectar(tape).parse();
        consume("fini_pollinate");
        if (nectar.isPresent()) {
            if (nectar.get() instanceof Signature) {
                skipPS();
                skipI();
            }
        }
        return new Pollinate(flower, primor, nectar);
    }
}
