package org.x96.sys.sc.ast;

public enum Flower implements ScTree {
    VARIABLE,
    CONSTANT;

    public String h() {
        return switch (this) {
            case VARIABLE -> "@";
            case CONSTANT -> "%";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        throw new RuntimeException("me implemente");
    }
}
