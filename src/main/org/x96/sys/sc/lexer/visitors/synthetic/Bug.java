package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c6.LatinSmallLetterB;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// bug = 'b' 'ug';
public class Bug extends LatinSmallLetterB {

    public Bug(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x62) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // text
        if (look() != 0x75) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        if (look() != 0x67) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x62
        ;
    }

    @Override
    public String overKind() {
        return "bug";
    }

}
