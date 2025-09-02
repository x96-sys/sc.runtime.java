package org.x96.sys.sc.ast.synthetic;

public interface ScTree {
    void prettyPrint(String indent);

    default String label() {
        return getClass().getSimpleName();
    }
}
