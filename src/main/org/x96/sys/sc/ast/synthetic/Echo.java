package org.x96.sys.sc.ast.synthetic;

public record Echo(byte[] raw) implements Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > '%s'%n", indent, label(), new String(raw));
    }
}
