package org.x96.sys.sc.ast.synthetic;

public record Hex(int raw) implements Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %X%n", indent, label(), raw);
    }
}
