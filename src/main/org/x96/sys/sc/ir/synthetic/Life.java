package org.x96.sys.sc.ir.synthetic;

public record Life(boolean state) implements Flow {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%s]%n", indent, label(), state);
    }
}
