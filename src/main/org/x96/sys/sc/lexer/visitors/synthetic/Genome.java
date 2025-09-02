package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.Visitor;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.router.switcher.Switcher;

// genome = (anatomy | behavior);
public class Genome extends Visitor {

    public Genome(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Anatomy.class);
        // switch term
        switcher.know(Behavior.class);
        push(switcher.stream(tokenizer));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // switch
        // nucleus
        // term
        new Anatomy(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Behavior(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "genome";
    }

}
