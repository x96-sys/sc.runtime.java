package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Spore(Id id, Impulse impulse) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        throw new RuntimeException("me implemente");
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
