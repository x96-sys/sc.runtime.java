package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public record Habit(Id id, Pulse[] pulses) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        id.prettyPrint(child);
        for (Pulse p : pulses) {
            p.prettyPrint(child);
        }
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
