package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Endo(byte raw) implements Neuron {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), (char) raw);
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
