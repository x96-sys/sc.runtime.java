package org.x96.sys.sc.lexer.visitors.synthetic;

import org.x96.sys.lexer.visitor.Visitor;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.router.switcher.Switcher;
import org.x96.sys.lexer.visitor.entry.terminals.c2.Space;
import org.x96.sys.lexer.visitor.entry.terminals.c0.Ht;
import org.x96.sys.lexer.visitor.entry.terminals.c0.Cr;
import org.x96.sys.lexer.visitor.entry.terminals.c0.Lf;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;

// i = @ (0x20 | 0x9 | 0xD | 0xA);
public class I extends Visitor {

    public I(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch natural
        switcher.know(Space.class);
        // switch natural
        switcher.know(Ht.class);
        // switch natural
        switcher.know(Cr.class);
        // switch natural
        switcher.know(Lf.class);
        push(switcher.stream(tokenizer));
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // switch
        // nucleus
        // natural
        look() == 0x20
        ||
        // nucleus
        // natural
        look() == 0x9
        ||
        // nucleus
        // natural
        look() == 0xD
        ||
        // nucleus
        // natural
        look() == 0xA
        ;
    }

    @Override
    public String overKind() {
        return "i";
    }

}
