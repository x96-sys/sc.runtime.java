package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Be(Id id) implements Bond {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException(
                "Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
