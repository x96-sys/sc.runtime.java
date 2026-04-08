package org.x96.sys.sc.ast;

public record Sc(Nymph nymph) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        nymph.prettyPrint(child);
    }
}
