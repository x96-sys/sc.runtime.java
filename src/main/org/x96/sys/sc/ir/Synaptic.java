package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Synaptic(Id id, Optional<Nerve> nerve) implements Nerve {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [.]%n", indent, label());
        String child = " ".repeat(4) + indent;
        id.prettyPrint(child);
        nerve.ifPresent(n -> n.prettyPrint(child));
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
