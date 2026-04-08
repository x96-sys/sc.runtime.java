package org.x96.sys.sc.ast;

public record Can(Primor primor) implements Tie {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
    }
}
