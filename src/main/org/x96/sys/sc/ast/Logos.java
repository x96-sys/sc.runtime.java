package org.x96.sys.sc.ast;

public record Logos(Primor web) implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        web.prettyPrint(child);
    }
}
