package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.filament;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Filament;
import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;

public class ParserFilament extends Parser<Filament> {
    public ParserFilament(Tape tape) {
        super(tape);
    }

    @Override
    public Filament parse() {
        consume("filament"); // &
        consume("filament"); // p
        consume("filament"); // [
        List<Primor> l = new ArrayList<>();
        followPrimor(l);
        consume("filament"); // ]
        return new Filament(l.toArray(Primor[]::new));
    }

    private void followPrimor(List<Primor> primors) {
        if (hasNextPrimor()){
            primors.add(new ParserPrimor(tape).parse());
            skipSpace();
            followPrimor(primors);
        }
    }
}
