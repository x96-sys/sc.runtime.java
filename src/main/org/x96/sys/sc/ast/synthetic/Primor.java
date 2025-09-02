package org.x96.sys.sc.ast.synthetic;

public record Primor(byte[] raw) implements Resonance, Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), new String(raw));
    }
}
