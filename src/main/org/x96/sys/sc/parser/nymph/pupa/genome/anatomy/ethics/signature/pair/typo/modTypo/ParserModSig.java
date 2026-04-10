package org.x96.sys.sc.parser.nymph.pupa.genome.anatomy.ethics.signature.pair.typo.modTypo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.ModSig;
import org.x96.sys.sc.parser.Parser;

public class ParserModSig extends Parser<ModSig> {
    public ParserModSig(Tape tape) {
        super(tape);
    }

    @Override
    public ModSig parse() {
        if (hasNextOptional()) {
            consume("optional"); // ?
            return ModSig.OPTIONAL;
        }
        if (hasNextArray()) {
            consume("init_array"); // [
            skipI();
            consume("fini_array"); // ]
            return ModSig.ARRAY;
        }
        if (hasNextSplat()) {
            consume("splat"); // *
            return ModSig.SPLAT;
        }
        throw new RuntimeException("?");
    }
}
