package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;

// primor = @ alpha primor_follow*;
public class Primor extends Alpha {

    public Primor(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Alpha(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new PrimorFollow(tokenizer).allowed()) {
            push(new PrimorFollow(tokenizer).safeVisit());
        }
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Alpha(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "primor";
    }

}
