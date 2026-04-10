package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Packet(Id id, Optional<Bond> bond) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        id.prettyPrint(child);
        bond.ifPresent(b -> b.prettyPrint(child));
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
