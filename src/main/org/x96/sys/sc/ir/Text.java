package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Text(byte[] raw) implements Serial, Neuron {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > '%s'%n", indent, label(), new String(raw));
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
