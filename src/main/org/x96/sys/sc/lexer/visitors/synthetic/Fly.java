package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;

// fly = forager course?;
public class Fly extends Forager {

    public Fly(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Forager(tokenizer).safeVisit());
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
        new Forager(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "fly";
    }

}
