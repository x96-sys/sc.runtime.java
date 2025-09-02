package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.nectar.signature.pair.typo.modTypo;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.ModTypo;
import org.x96.sys.sc.parser.Parser;

import java.util.Optional;

public class ParserOptionalModTypo extends Parser<Optional<ModTypo>> {
    public ParserOptionalModTypo(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<ModTypo> parse() {
        if (hasNextModTypo()) {
            return Optional.of(new ParserModTypo(tape).parse());
        }
        return Optional.empty();
    }
}
