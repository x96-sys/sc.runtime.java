package org.x96.sys.sc.ast;

public record Signature(Pair[] pairs) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), pairs.length);
        String child = " ".repeat(4) + indent;
        for (Pair p : pairs) {
            p.prettyPrint(child);
        }
    }
}
