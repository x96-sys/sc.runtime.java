package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Impulse(Neuron neuron, Optional<Nerve> nerve) implements Signal, Stimulus {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        neuron.prettyPrint(child);
        nerve.ifPresent(n -> n.prettyPrint(child));
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
