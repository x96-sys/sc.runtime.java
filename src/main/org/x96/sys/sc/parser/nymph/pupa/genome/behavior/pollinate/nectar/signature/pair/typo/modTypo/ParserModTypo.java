package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.typo.modTypo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.ModTypo;
import org.x96.sys.sc.parser.Parser;

public class ParserModTypo extends Parser<ModTypo> {
    public ParserModTypo(Tape tape) {
        super(tape);
    }

    @Override
    public ModTypo parse() {
        if (hasNextOptional()) {
            consume("optional"); // ?
            return ModTypo.OPTIONAL;
        }
        if (hasNextArray()) {
            consume("array"); // [
            consume("array"); // ]
            return ModTypo.ARRAY;
        }
        throw new RuntimeException("?");
    }
}
