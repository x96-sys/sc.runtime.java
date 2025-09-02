package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Impulse(Neuron neuron, Optional<Nerve> nerve) implements Signal, Stimulus {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        neuron.prettyPrint(child);
        nerve.ifPresent(n -> n.prettyPrint(child));
    }
}
