package org.x96.sys.sc.ast.synthetic;

public record Nymph(Pupa pupa) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        pupa.prettyPrint(child);
    }
}
