package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.filament;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Base;
import org.x96.sys.sc.ast.Filament;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast.Rna;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.filament.typed.ParserBase;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserFilament extends Parser<Filament> {
    public ParserFilament(Tape tape) {
        super(tape);
    }

    @Override
    public Filament parse() {
        // filament = '&' i* axon ']';
        consume("filament"); // &
        skipI();
        Optional<Base> typed = Optional.of(new ParserBase(tape).parse());
        if (typed.isEmpty()) {
            throw new RuntimeException("filament typed is empty");
        }

        List<Rna> rna = new ArrayList<>();

        switch (typed.get()) {
            case PRIMOR -> {
                followFilamentPrimor(rna);
            }
            case ECHO -> {
                followFilamentEcho(rna);
            }
            case NORTE -> {
                followFilamentNorte(rna);
            }
        }
        consume("filament"); // ]

        return new Filament(typed, rna.toArray(Rna[]::new));
    }

    private void followFilamentNorte(List<Rna> rna) {
        throw new RuntimeException("filament norte is not implemented");
    }

    private void followFilamentEcho(List<Rna> rna) {
        throw new RuntimeException("filament norte is not implemented");
    }

    private void followFilamentPrimor(List<Rna> rna) {
        consume("lp");
        followFilamentPrimorLiteral(rna);
    }

    private void followFilamentPrimorLiteral(List<Rna> rna) {
        if (hasNextPrimor()) {
            rna.add(new ParserPrimor(tape).parse());
            skipSpace();
            followFilamentPrimorLiteral(rna);
        }
    }

    private void followPrimor(List<Primor> primors) {
        if (hasNextPrimor()) {
            primors.add(new ParserPrimor(tape).parse());
            skipSpace();
            followPrimor(primors);
        }
    }
}
