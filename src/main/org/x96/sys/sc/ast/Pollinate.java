package org.x96.sys.sc.ast;

import java.util.Optional;

public record Pollinate(Flower flower, Primor primor, Optional<Nectar> nectar) implements Behavior {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%s]%n", indent, label(), flower.h());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
        nectar.ifPresent(n -> n.prettyPrint(child));
    }
}
