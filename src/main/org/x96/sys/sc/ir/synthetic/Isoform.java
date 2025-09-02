package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Isoform(Optional<Formula> formula, Id id) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        formula.ifPresent(f -> f.prettyPrint(child));
        id.prettyPrint(child);
    }
}
