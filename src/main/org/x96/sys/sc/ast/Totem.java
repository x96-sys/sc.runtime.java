package org.x96.sys.sc.ast;

import java.util.Optional;

public record Totem(
        Primor primor, Norte[] nortes, Ethics[] ethics, Optional<Generalization> generalization)
        implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf(
                "%s%s > %s [%d]%n", indent, label(), new String(primor.raw()), nortes.length);
        String child = " ".repeat(4) + indent;
        for (Norte p : nortes) {
            p.prettyPrint(child);
        }
        for (Ethics e : ethics) {
            e.prettyPrint(child);
        }
    }
}
