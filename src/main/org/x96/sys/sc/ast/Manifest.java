package org.x96.sys.sc.ast;

public record Manifest(Behavior[] behavior) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        for (Behavior b : behavior) {
            b.prettyPrint(child);
        }
    }
}
