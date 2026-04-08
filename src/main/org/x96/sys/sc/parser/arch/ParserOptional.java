package org.x96.sys.sc.parser.arch;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.ScTree;

import java.util.Optional;

public class ParserOptional<T extends ScTree> extends Parser implements ParsingOptional<T> {
    public ParserOptional(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<T> parse() {
        return Optional.empty();
    }
}
