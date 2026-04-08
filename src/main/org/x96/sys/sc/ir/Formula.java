package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public enum Formula implements ScIr {
    ARRAY,
    OPTIONAL,
    SPLAT;

    public String h() {
        return switch (this) {
            case ARRAY -> "[]";
            case OPTIONAL -> "?";
            case SPLAT -> "*";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), h());
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
