package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.Visitor;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.router.switcher.Switcher;

// nectar = (fly | echo);
public class Nectar extends Visitor {

    public Nectar(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Fly.class);
        // switch term
        switcher.know(Echo.class);
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
        new Fly(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Echo(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "nectar";
    }

}
