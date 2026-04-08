package org.x96.sys.sc.ast;

public interface ScTree {
    void prettyPrint(String indent);

    default String label() {
        return getClass().getSimpleName();
    }
}
