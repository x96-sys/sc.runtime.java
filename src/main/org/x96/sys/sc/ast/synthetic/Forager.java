package org.x96.sys.sc.ast.synthetic;

public record Forager(boolean self, Primor primor) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
    }
}
