package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Synaptic(Id id, Optional<Nerve> nerve) implements Nerve {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [.]%n", indent, label());
        String child = " ".repeat(4) + indent;
        id.prettyPrint(child);
        nerve.ifPresent(n -> n.prettyPrint(child));
    }
}
