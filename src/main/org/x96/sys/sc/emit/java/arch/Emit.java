package org.x96.sys.sc.emit.java.arch;


public abstract class Emit<T> implements Emitting {
    public final T t;

    public Emit(T var1) {
        this.t = var1;
    }

    @Override
    public String toJava() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
