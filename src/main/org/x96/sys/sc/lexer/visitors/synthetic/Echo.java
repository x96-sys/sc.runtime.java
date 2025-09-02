package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;

// echo = @ q word+ q;
public class Echo extends Q {

    public Echo(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Q(tokenizer).safeVisit());
        // nucleus
        // term
        do {
            push(new Word(tokenizer).safeVisit());
        } while (// term
            new Word(tokenizer).allowed());
        // nucleus
        // term
        push(new Q(tokenizer).safeVisit());
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Q(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "echo";
    }

}
