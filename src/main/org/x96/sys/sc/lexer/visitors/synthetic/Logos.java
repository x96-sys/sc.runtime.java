package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c6.LatinSmallLetterL;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// logos = 'l' 'ogos';
public class Logos extends LatinSmallLetterL {

    public Logos(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x6C) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // text
        if (look() != 0x6F) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x67) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x6F) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x73) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x6C
        ;
    }

    @Override
    public String overKind() {
        return "logos";
    }

}
