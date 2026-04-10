package org.x96.sys.sc.ir;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IdTest {

    @Test
    void happy() {
        byte[] payload = "root".getBytes();
        Id id = new Id(payload);
        assertArrayEquals(payload, id.raw());
    }

    @Test
    void happyEq() {
        assertEquals(new Id("root".getBytes()), new Id("root".getBytes()));
        assertEquals(new Id("tree".getBytes()), new Id("tree".getBytes()));
        assertEquals(new Id("z_ero".getBytes()), new Id("z_ero".getBytes()));
    }

    @Test
    void unhappyEq() {
        assertNotEquals(new Id("root".getBytes()), new Id("rooT".getBytes()));

        assertNotEquals(new Id("ROOT".getBytes()), new Id("root".getBytes()));

        assertNotEquals(new Id("trEe".getBytes()), new Id("tree".getBytes()));

        assertNotEquals(new Id("zero".getBytes()), new Id("z_ero".getBytes()));
    }
}
