package org.x96.sys.sc.ir.synthetic;

public enum Formula implements ScIr {
    ARRAY, OPTIONAL;

    public String h() {
        return switch (this) {
            case ARRAY -> "[]";
            case OPTIONAL -> "?";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), h());
    }
}
