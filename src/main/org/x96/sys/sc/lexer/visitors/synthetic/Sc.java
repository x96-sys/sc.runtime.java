package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;

// sc = stx i* nymph etx;
public class Sc extends Stx {

    public Sc(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Stx(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new Nymph(tokenizer).safeVisit());
        // nucleus
        // term
        push(new Etx(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Stx(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "sc";
    }

}
