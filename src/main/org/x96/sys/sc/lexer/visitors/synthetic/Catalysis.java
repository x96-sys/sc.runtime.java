package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.entry.terminals.c2.FullStop;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;

// catalysis = '.' i* primor course?;
public class Catalysis extends FullStop {

    public Catalysis(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x2E) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new Primor(tokenizer).safeVisit());
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
        // text
        look() == 0x2E
        ;
    }

    @Override
    public String overKind() {
        return "catalysis";
    }

}
