package org.x96.sys.sc.ast.synthetic;

import java.util.Optional;

public record Typo(Optional<ModTypo> modTypo, Primor primor) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        String mod = String.format("%s", modTypo.map(m -> " " + m.h()).orElse(""));
        System.out.printf("%s%s%s%n", indent, label(), mod);
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
    }
}
