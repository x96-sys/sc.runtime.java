package org.x96.sys.sc.ast;

public record Ipse(byte raw) implements Forager {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), (char) raw);
    }
}
