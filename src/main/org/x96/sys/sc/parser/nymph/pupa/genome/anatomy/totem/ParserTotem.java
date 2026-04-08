package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.ParserEthics;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.generalization.ParserOptionalGeneralization;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.totem.norte.ParserNorte;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserTotem extends Parser<Totem> {
    public ParserTotem(Tape tape) {
        super(tape);
    }

    @Override
    public Totem parse() {
        skip("totem");
        skipI();
        Primor primor = new ParserPrimor(tape).parse();
        skipI();
        Optional<Generalization> generalization = new ParserOptionalGeneralization(tape).parse();
        skipI();
        List<Norte> nortes = new ArrayList<>();
        List<Ethics> ethics = new ArrayList<>();
        followTotemContent(nortes, ethics);
        return new Totem(
                primor,
                nortes.toArray(Norte[]::new),
                ethics.toArray(Ethics[]::new),
                generalization);
    }

    private void followTotemContent(List<Norte> nortes, List<Ethics> ethics) {
        if (hasNextPrimor()) {
            nortes.add(new ParserNorte(tape).parse());
            skipI();
            followTotemContent(nortes, ethics);
        }
        if (hasNextAnatomy()) {
            consume("init_anatomy");
            skipI();
            ethics.add(new ParserEthics(tape).parse());
            skipI();
            consume("fini_anatomy");
            skipI();
            followTotemContent(nortes, ethics);
        }
    }
}
