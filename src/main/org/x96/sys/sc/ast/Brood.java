package org.x96.sys.sc.ast;

public record Brood(Nectar[] nectar) implements Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), nectar.length);
        String child = " ".repeat(4) + indent;
        for (Nectar n : nectar) {
            n.prettyPrint(child);
        }
    }
}
