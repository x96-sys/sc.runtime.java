package org.x96.sys.sc.ast;

public enum ModSig implements ScTree {
    ARRAY,
    OPTIONAL,
    SPLAT;

    public String h() {
        return switch (this) {
            case ARRAY -> "[]";
            case OPTIONAL -> "?";
            case SPLAT -> "*";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), h());
    }
}
