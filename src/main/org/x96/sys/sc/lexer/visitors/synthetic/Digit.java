package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c3.DigitZero;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// digit = [0x30-0x39];
public class Digit extends DigitZero {

    public Digit(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x30 || look() > 0x39) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x30 && look() <= 0x39)
        ;
    }

    @Override
    public String overKind() {
        return "digit";
    }

}
