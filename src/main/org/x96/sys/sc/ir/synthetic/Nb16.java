package org.x96.sys.sc.ir.synthetic;

public record Nb16(int raw) implements  Signal {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %X%n", indent, label(), raw);
    }
}
