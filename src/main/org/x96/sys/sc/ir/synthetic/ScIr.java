package org.x96.sys.sc.ir.synthetic;

public interface ScIr {
    void prettyPrint(String indent);

    default String label() {
        return getClass().getSimpleName();
    }
}
