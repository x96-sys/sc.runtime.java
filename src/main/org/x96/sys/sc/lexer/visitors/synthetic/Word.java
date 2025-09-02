package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// word = !q any;
public class Word extends Q {

    public Word(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        if (new Q(tokenizer).allowed()) throw new BuzzVisitorMismatch(this, this.tokenizer);
        // nucleus
        // term
        push(new Any(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Q(tokenizer).denied()
        &&
        // nucleus
        // term
        new Any(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "word";
    }

}
