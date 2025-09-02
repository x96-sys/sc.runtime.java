package org.x96.sys.sc.bake;

import org.junit.jupiter.api.Test;
import org.x96.sys.sc.ast.synthetic.Primor;

import static org.junit.jupiter.api.Assertions.*;

class BakePrimorTest {
    @Test
    void happy(){
        byte[] payload = "kernel".getBytes();
        BakePrimor bakePrimor = new BakePrimor();
        bakePrimor.setRaw(payload);
        Primor primor = bakePrimor.bake();
        assertArrayEquals(payload, primor.raw());

    }
}