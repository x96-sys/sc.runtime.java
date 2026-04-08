package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Base;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Axoneme;

public class BaseToAxoneme implements ToIr<Base, Axoneme> {
    @Override
    public Axoneme convert(Base base) {
        return switch (base) {
            case PRIMOR -> Axoneme.ID;
            case ECHO -> Axoneme.TEXT;
            case NORTE -> Axoneme.DIRECTION;
        };
    }
}
