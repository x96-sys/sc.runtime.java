package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.fly.forager.echo;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.IoTest.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Echo;
import org.x96.sys.sc.ast2ir.converters.EchoToText;
import org.x96.sys.sc.emit.targets.Ruby;
import org.x96.sys.sc.emit.targets.SC;
import org.x96.sys.sc.ir.Text;

class ParserEchoTest {
    public Token[] tokenizer(byte[] payload) {
        return new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Echo.class).lex(payload);
    }

    @Test
    void happy() {
        byte[] payload = "'sc lang'".getBytes();
        Token[] tokens = tokenizer(payload);
        Echo echo = new ParserEcho(new Tape(tokens)).parse();
        assertPrintLn("Echo > 'sc lang'", () -> echo.prettyPrint(""));
        assertArrayEquals("sc lang".getBytes(), echo.raw());
        EchoToText echoToText = new EchoToText();
        Text text = echoToText.convert(echo);
        assertPrintLn("Text > 'sc lang'", () -> text.prettyPrint(""));
        assertArrayEquals("sc lang".getBytes(), text.raw());
        assertEquals("'sc lang'", new SC().visit(text, ""));
        assertEquals("\"sc lang\"", new Ruby().visit(text, ""));
    }
}
