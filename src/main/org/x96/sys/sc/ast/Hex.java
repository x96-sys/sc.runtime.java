package org.x96.sys.sc.ast;

public record Hex(int raw) implements Forager {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %X%n", indent, label(), raw);
    }
}
