package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.typo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.ModSig;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast.Typo;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.primor.ParserPrimor;

import java.util.List;

public class ParserTypo extends Parser<Typo> {
    private final List<ModSig> mods;

    public ParserTypo(Tape tape, List<ModSig> mods) {
        super(tape);
        this.mods = mods;
    }

    @Override
    public Typo parse() {
        consume("typo"); // :
        followOptionalModSig(mods);
        Primor primor = new ParserPrimor(tape).parse();
        followOptionalModSig(mods);
        return new Typo(primor);
    }
}
