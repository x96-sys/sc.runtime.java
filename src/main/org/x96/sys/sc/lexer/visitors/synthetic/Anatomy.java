package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.router.switcher.Switcher;

// anatomy = init_anatomy i* (bug | totem | logos | know) i* fini_anatomy;
public class Anatomy extends InitAnatomy {

    public Anatomy(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new InitAnatomy(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Bug.class);
        // switch term
        switcher.know(Totem.class);
        // switch term
        switcher.know(Logos.class);
        // switch term
        switcher.know(Know.class);
        push(switcher.stream(tokenizer));
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new FiniAnatomy(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new InitAnatomy(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "anatomy";
    }

}
