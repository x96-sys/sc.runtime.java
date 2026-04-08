package org.x96.sys.sc.ast;

public record Primor(byte[] raw) implements Resonance, Forager, Rna {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), new String(raw));
    }
}
