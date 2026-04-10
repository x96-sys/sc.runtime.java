package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Rune(Id id, Direction[] directions, Pulse[] pulses, Optional<Bundle> bundle)
        implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf(
                "%s%s > %s [%d] %n", indent, label(), new String(id.raw()), directions.length);
        String child = " ".repeat(4) + indent;
        bundle.ifPresent(b -> b.prettyPrint(child));
        for (Direction i : directions) {
            i.prettyPrint(child);
        }
        for (Pulse p : pulses) {
            p.prettyPrint(child);
        }
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
