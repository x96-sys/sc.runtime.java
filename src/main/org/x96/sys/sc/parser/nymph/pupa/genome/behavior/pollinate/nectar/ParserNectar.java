package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Filament;
import org.x96.sys.sc.ast.synthetic.Nectar;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.ParserFly;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.echo.ParseEcho;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.filament.ParserFilament;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.hex.ParserHex;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.ParserSignature;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

public class ParserNectar extends Parser<Nectar> {
    public ParserNectar(Tape tape) {
        super(tape);
    }

    @Override
    public Nectar parse() {
        if (hasNextNectar()) {
            if (hasNextEcho()) {
                return new ParseEcho(tape).parse();
            }

            if (hasNextSignature()) {
                return new ParserSignature(tape).parse();
            }

            if (hasNextPrimorLiteral()){
                consume("primor_literal");
                return new ParserPrimor(tape).parse();
            }

            if(hasNextFly()){
                return new ParserFly(tape).parse();
            }

            if (hasNextFilament()){
                return new ParserFilament(tape).parse();
            }

            if (hasNextHex()){
                return new ParserHex(tape).parse();
            }

            System.out.println(tape.current().toString());
            throw new RuntimeException("como tratar?");
        }

        System.out.println(tape.current().toString());
        throw new RuntimeException("Nectar not found");
    }
}
