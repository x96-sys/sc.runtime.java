package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.gene;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserGene extends Parser<Gene> {
    public ParserGene(Tape tape) {
        super(tape);
    }

    @Override
    public Gene parse() {
        skip("gene");
        List<ModSig> mods = new ArrayList<>();
        followOptionalModSig(mods);
        Primor attr = new ParserPrimor(tape).parse();
        followOptionalModSig(mods);
        Primor typo = new ParserPrimor(tape).parse();
        followOptionalModSig(mods);
        return new Gene(
                new Pair(
                        mods.toArray(ModSig[]::new),
                        Optional.of(new Attribute(Optional.of(attr))),
                        new Typo(typo)));
    }
}
