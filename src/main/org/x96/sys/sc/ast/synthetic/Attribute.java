package org.x96.sys.sc.ast.synthetic;

import java.util.Optional;

public record Attribute(boolean splat, Optional<Primor> primor) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        String splat = String.format("%s", this.splat ? " [*]" : "");
        System.out.printf("%s%s%s%n", indent, label(), splat);
        String child = " ".repeat(4) + indent;
        primor.ifPresent(p -> p.prettyPrint(child));
    }
}
