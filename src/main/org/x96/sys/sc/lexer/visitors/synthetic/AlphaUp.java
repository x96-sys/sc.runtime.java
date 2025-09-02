package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c4.LatinCapitalLetterA;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// alpha_up = [0x41-0x5A];
public class AlphaUp extends LatinCapitalLetterA {

    public AlphaUp(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x41 || look() > 0x5A) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x41 && look() <= 0x5A)
        ;
    }

    @Override
    public String overKind() {
        return "alpha_up";
    }

}
