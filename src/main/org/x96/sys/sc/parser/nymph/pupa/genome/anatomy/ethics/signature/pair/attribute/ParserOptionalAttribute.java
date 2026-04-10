package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.attribute;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Attribute;
import org.x96.sys.sc.ast.ModSig;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.List;
import java.util.Optional;

public class ParserOptionalAttribute extends ParserOptional<Attribute> {
    private final List<ModSig> mods;

    public ParserOptionalAttribute(Tape tape, List<ModSig> mods) {
        super(tape);
        this.mods = mods;
    }

    @Override
    public Optional<Attribute> parse() {
        followOptionalModSig(mods);
        Optional<Attribute> attribute = Optional.empty();
        if (hasNextAttribute()) {
            attribute = Optional.of(new ParserAttribute(tape).parse());
            followOptionalModSig(mods);
        }
        return attribute;
    }
}
