package org.x96.sys.sc.ir;

public interface ScIr extends Visitable {
    void prettyPrint(String indent);

    default String label() {
        return getClass().getSimpleName();
    }
}
