package org.x96.sys.sc.ast;

public record Generalization(Abstraction[] abstractions) implements Resonance {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        for (Abstraction a : abstractions) {
            a.prettyPrint(child);
        }
    }
}
