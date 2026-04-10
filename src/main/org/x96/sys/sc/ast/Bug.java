package org.x96.sys.sc.ast;

import java.util.Optional;

public record Bug(
        Primor primor,
        Gene[] genes,
        Ethics[] ethics,
        Can[] cans,
        As[] as,
        Optional<Generalization> generalization)
        implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
        for (Gene g : genes) {
            g.prettyPrint(child);
        }
        for (Can c : cans) {
            c.prettyPrint(child);
        }
        for (Ethics e : ethics) {
            e.prettyPrint(child);
        }
    }
}
