package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Arrays;

public record Id(byte[] raw) implements Flow, Serial, Neuron {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), new String(raw));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Id id = (Id) obj;
        return Arrays.equals(raw, id.raw);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(raw);
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
