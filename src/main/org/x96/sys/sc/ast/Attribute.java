package org.x96.sys.sc.ast;

import java.util.Optional;

public record Attribute(Optional<Primor> primor) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.ifPresent(p -> p.prettyPrint(child));
    }
}
