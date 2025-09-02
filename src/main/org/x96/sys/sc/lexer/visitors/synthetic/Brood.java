package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;

// brood = nectar i* nectar_follow*;
public class Brood extends Nectar {

    public Brood(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Nectar(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        while (// term
            new NectarFollow(tokenizer).allowed()) {
            push(new NectarFollow(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Nectar(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "brood";
    }

}
