package org.x96.sys.sc.ast;

import java.util.Optional;

public record Pair(ModSig[] modSigs, Optional<Attribute> attribute, Typo typo) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        attribute.ifPresent(a -> a.prettyPrint(child));
        typo.prettyPrint(child);
        for (ModSig mod : modSigs) {
            mod.prettyPrint(child);
        }
    }
}
