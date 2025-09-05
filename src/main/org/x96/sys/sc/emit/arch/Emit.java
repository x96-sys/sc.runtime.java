package org.x96.sys.sc.emit.arch;


public abstract class Emit<T> implements Emitting {
    public final T t;

    public Emit(T t) {
        this.t = t;
    }

    @Override
    public String toSC() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
