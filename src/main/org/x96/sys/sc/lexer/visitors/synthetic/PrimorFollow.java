package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.Visitor;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.router.switcher.Switcher;

// primor_follow = (alpha | digit | ghost);
public class PrimorFollow extends Visitor {

    public PrimorFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Alpha.class);
        // switch term
        switcher.know(Digit.class);
        // switch term
        switcher.know(Ghost.class);
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
        new Alpha(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Digit(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Ghost(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "primor_follow";
    }

}
