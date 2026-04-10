package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Nb16(int raw) implements Neuron {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > 0x%X%n", indent, label(), raw);
    }

    public Nb16 add(Nb16 nb) {
        return new Nb16(raw + nb.raw);
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
