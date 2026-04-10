package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Life(boolean state) implements Flow {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%s]%n", indent, label(), state);
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
