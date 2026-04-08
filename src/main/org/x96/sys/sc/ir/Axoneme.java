package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public enum Axoneme implements ScIr {
    ID,
    TEXT,
    DIRECTION,
    ;

    public String h() {
        return switch (this) {
            case ID -> "p";
            case TEXT -> "e";
            case DIRECTION -> "n";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        throw new RuntimeException("n estou pronto para isso");
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
