package org.x96.sys.sc.emit.arch;

public class DoubleEmit<P,Q> implements Emitting {
    public final P p;
    public final Q q;

    public DoubleEmit(P p, Q q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toSC() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
