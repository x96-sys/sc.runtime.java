package org.x96.sys.sc.ast;

public record Ready(boolean state) implements Resonance {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%s]%n", indent, label(), state);
    }
}
