package org.x96.sys.sc.bake;

import org.x96.sys.sc.ast.synthetic.Primor;

public class BakePrimor extends Bake<Primor> {

    private byte[] raw;

    public void setRaw(byte[] raw) {
        this.raw = raw;
    }

    @Override
    public Primor bake() {
        return new Primor(raw);
    }
}
