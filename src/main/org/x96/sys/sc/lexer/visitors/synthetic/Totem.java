package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c7.LatinSmallLetterT;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// totem = 't' 'otem';
public class Totem extends LatinSmallLetterT {

    public Totem(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x74) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // text
        if (look() != 0x6F) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x74) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x65) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x6D) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x74
        ;
    }

    @Override
    public String overKind() {
        return "totem";
    }

}
