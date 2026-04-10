package org.x96.sys.sc.ast;

import java.util.Optional;

public record Filament(Optional<Base> base, Rna[] rna) implements Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), rna.length);
        String child = " ".repeat(4) + indent;
        for (Rna p : rna) {
            p.prettyPrint(child);
        }
    }
}
