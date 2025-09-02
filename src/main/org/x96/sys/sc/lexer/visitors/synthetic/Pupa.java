package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;

// pupa = genome_follow+;
public class Pupa extends GenomeFollow {

    public Pupa(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        do {
            push(new GenomeFollow(tokenizer).safeVisit());
        } while (// term
            new GenomeFollow(tokenizer).allowed());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new GenomeFollow(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "pupa";
    }

}
