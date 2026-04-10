package org.x96.sys.sc.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.buzz.lexer.BuzzLex;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;

class ParserSCTest {
    // GRAMMAR; +/- AST
    // anatomy = init_anatomy i* (bug | totem | logos | know | ethics | skill) i*
    // fini_anatomy;
    // behavior = (pollinate | fly);
    //
    // genome = (anatomy | behavior);
    //
    // pupa = genome_follow+;
    // nymph = pupa;
    // sc = stx i* nymph etx;

    public Token[] tokenizer(byte[] payload) {
        return new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Sc.class).lexWrapped(payload);
    }

    @Test
    void happyBuzzLex() {
        byte[] payload = "".getBytes();
        var e = assertThrows(BuzzLex.class, () -> tokenizer(payload));
        assertEquals(
                """
                🦕 [0x71]
                🐝 [BuzzLex]
                🌵 >\s
                  1 | \u0002\u0003
                1:1 | ^
                  2 |\s
                """,
                e.getMessage());
        assertNotNull(e.getCause());
        var c = e.getCause();
        assertEquals(
                """
                🦕 [0xFFF]
                🐝 [BuzzVisitorMismatch]
                🌵 > Atual visitante [Nymph] encontrou token [0x3] inesperado;
                   > Tokenizer.pointer[1]
                   > Tokens Allowed [0x24, 0x25, 0x27, 0x30, 0x3A, 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A, 0x4B, 0x4C, 0x4D, 0x4E, 0x4F, 0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59, 0x5A, 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A]
                  1 | 
                1:1 | ^
                  2 |\s
                """,
                c.getMessage());
        assertNull(c.getCause());
    }

    @Test
    void happyAnatomyBug() {
        byte[] payload = ":bug Hex;".getBytes();
        Token[] tokens = tokenizer(payload);
        Sc sc = new ParserSC(new Tape(tokens)).parse();
        assertEquals(1, sc.nymph().pupa().genome().length);
        var look = sc.nymph().pupa().genome()[0];
        assertInstanceOf(Anatomy.class, look);
        assertInstanceOf(Bug.class, look);
        Bug bug = (Bug) look;
        assertArrayEquals("Hex".getBytes(), bug.primor().raw());
        assertEquals(0, bug.genes().length);
        assertEquals(0, bug.ethics().length);
        assertEquals(0, bug.cans().length);
        assertEquals(0, bug.as().length);
        assertTrue(bug.generalization().isEmpty());
    }

    @Test
    void happyBehaviorFly() {
        byte[] payload = "0x96".getBytes();
        Token[] tokens = tokenizer(payload);
        Sc sc = new ParserSC(new Tape(tokens)).parse();
        assertEquals(1, sc.nymph().pupa().genome().length);
        var look = sc.nymph().pupa().genome()[0];
        assertInstanceOf(Behavior.class, look);
        assertInstanceOf(Fly.class, look);
        Fly fly = (Fly) look;
        assertInstanceOf(Hex.class, fly.forager());
        assertTrue(fly.course().isEmpty());
        Hex forager = (Hex) fly.forager();
        assertEquals(0x96, forager.raw());
    }

    @Test
    void happyBehaviorPollinate() {
        byte[] payload = "@varName = 0x96;".getBytes();
        Token[] tokens = tokenizer(payload);
        Sc sc = new ParserSC(new Tape(tokens)).parse();
        assertEquals(1, sc.nymph().pupa().genome().length);
        var look = sc.nymph().pupa().genome()[0];
        assertInstanceOf(Behavior.class, look);
        assertInstanceOf(Pollinate.class, look);
        Pollinate pollinate = (Pollinate) look;
        assertEquals(Flower.VARIABLE, pollinate.flower());
        assertArrayEquals("varName".getBytes(), pollinate.primor().raw());
        assertTrue(pollinate.nectar().isPresent());
        Nectar nectar = pollinate.nectar().get();
        assertInstanceOf(Fly.class, nectar);
        Fly fly = (Fly) nectar;
        assertInstanceOf(Hex.class, fly.forager());
        assertTrue(fly.course().isEmpty());
        Hex forager = (Hex) fly.forager();
        assertEquals(0x96, forager.raw());
    }
}
