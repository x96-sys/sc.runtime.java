package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Attribute;
import org.x96.sys.sc.ast.ModSig;
import org.x96.sys.sc.ast.Pair;
import org.x96.sys.sc.ast.Typo;
import org.x96.sys.sc.parser.Parser;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.attribute.ParserOptionalAttribute;
import org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.typo.ParserTypo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserPair extends Parser<Pair> {
    public ParserPair(Tape tape) {
        super(tape);
    }

    @Override
    public Pair parse() {
        List<ModSig> mods = new ArrayList<>();
        Optional<Attribute> attribute = new ParserOptionalAttribute(tape, mods).parse();
        Typo typo = new ParserTypo(tape, mods).parse();
        return new Pair(mods.toArray(ModSig[]::new), attribute, typo);
    }
}
