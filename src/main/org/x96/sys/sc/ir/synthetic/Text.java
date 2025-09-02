package org.x96.sys.sc.ir.synthetic;

public record Text(byte[] raw) implements Signal {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > '%s'%n", indent, label(), new String(raw));

    }
}
