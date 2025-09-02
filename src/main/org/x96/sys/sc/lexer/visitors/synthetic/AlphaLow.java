package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c6.LatinSmallLetterA;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// alpha_low = [0x61-0x7A];
public class AlphaLow extends LatinSmallLetterA {

    public AlphaLow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x61 || look() > 0x7A) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x61 && look() <= 0x7A)
        ;
    }

    @Override
    public String overKind() {
        return "alpha_low";
    }

}
