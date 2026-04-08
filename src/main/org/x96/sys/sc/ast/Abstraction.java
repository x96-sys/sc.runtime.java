package org.x96.sys.sc.ast;

import java.util.Optional;

public record Abstraction(Primor primor, Optional<Tie> tie) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
        tie.ifPresent(t -> t.prettyPrint(child));
    }
}
