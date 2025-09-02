package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Schema(Neurotransmitter[] neurotransmitters, Optional<Flow> flow) implements Signal {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        for (Neurotransmitter n : neurotransmitters) {
            n.prettyPrint(child);
        }
        flow.ifPresent(f -> f.prettyPrint(child));

    }
}
