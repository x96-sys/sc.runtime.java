package org.x96.sys.sc.parser;

import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;

public abstract class Parser<T extends ScTree> extends org.x96.sys.sc.parser.arch.Parser
        implements Parsing<T> {
    public Parser(Tape tape) {
        super(tape);
    }

    @Override
    public T parse() {
        throw new RuntimeException("deve ser implementado na classe filha");
    }
}
