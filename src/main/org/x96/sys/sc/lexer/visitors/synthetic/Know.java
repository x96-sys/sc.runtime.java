package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c6.LatinSmallLetterK;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// know = 'k' 'now';
public class Know extends LatinSmallLetterK {

    public Know(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x6B) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // text
        if (look() != 0x6E) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x6F) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x77) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x6B
        ;
    }

    @Override
    public String overKind() {
        return "know";
    }

}
