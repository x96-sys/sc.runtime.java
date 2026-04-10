package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.*;

class ParserPollinateTest {
    public Token[] tokenizer(byte[] payload) {
        return new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Pollinate.class).lex(payload);
    }

    @Test
    void happy() {
        byte[] payload = "@echo = {raw: hex}; ".getBytes();
        Token[] tokens = tokenizer(payload);
        Pollinate pollinate = new ParserPollinate(new Tape(tokens)).parse();
        assertEquals(Flower.VARIABLE, pollinate.flower());
        assertArrayEquals("echo".getBytes(), pollinate.primor().raw());
        assertTrue(pollinate.nectar().isPresent());
        Nectar nectar = pollinate.nectar().get();
        assertNotNull(nectar);
        assertInstanceOf(Aura.class, nectar);
        Aura aura = (Aura) nectar;
        assertNotNull(aura);
        assertFalse(aura.resonance().isPresent());
        assertNotNull(aura.signature());
        Signature signature = aura.signature();
        assertEquals(1, signature.pairs().length);
        Pair pair = signature.pairs()[0];
        assertEquals(0, pair.modSigs().length);
        assertTrue(pair.attribute().isPresent());
        Attribute attribute = pair.attribute().get();
        assertTrue(attribute.primor().isPresent());
        assertArrayEquals("raw".getBytes(), attribute.primor().get().raw());
        assertArrayEquals("hex".getBytes(), pair.typo().primor().raw());
    }
}
