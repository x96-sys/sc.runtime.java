package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.typo.modTypo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.ModSig;
import org.x96.sys.sc.parser.arch.ParserOptional;

import java.util.Optional;

public class ParserOptionalModSig extends ParserOptional<ModSig> {
    public ParserOptionalModSig(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<ModSig> parse() {
        if (hasNextModSig()) {
            return Optional.of(new ParserModSig(tape).parse());
        }
        return Optional.empty();
    }
}
