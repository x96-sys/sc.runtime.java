package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public enum Nature implements ScIr {
    MUTABLE,
    FIXED;

    public String h() {
        return switch (this) {
            case MUTABLE -> "mutable";
            case FIXED -> "fixed";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > [%s]%n", indent, label(), h());
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
