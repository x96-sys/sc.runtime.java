package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;

// carrier = init_carrier i* brood? fini_carrier course?;
public class Carrier extends InitCarrier {

    public Carrier(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new InitCarrier(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        if (// term
            new Brood(tokenizer).allowed()) {
            push(new Brood(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new FiniCarrier(tokenizer).safeVisit());
        // nucleus
        // term
        if (// term
            new Course(tokenizer).allowed()) {
            push(new Course(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new InitCarrier(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "carrier";
    }

}
