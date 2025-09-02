package org.x96.sys.sc.ast.synthetic;

public record Brood(Nectar[] nectar) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), nectar.length);
        String child = " ".repeat(4) + indent;
        for (Nectar n : nectar) {
            n.prettyPrint(child);
        }
    }
}
