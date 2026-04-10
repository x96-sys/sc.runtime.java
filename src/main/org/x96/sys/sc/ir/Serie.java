package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Serie(Optional<Axoneme> axoneme, Serial[] serialized) implements Signal {
    @Override
    public void prettyPrint(String indent) {
        String axoneme = axoneme().map(t -> String.format(" {%s}", t.h())).orElse("");
        System.out.printf("%s%s%s [%d]%n", indent, label(), axoneme, serialized.length);
        String child = " ".repeat(4) + indent;
        for (Serial s : serialized) {
            s.prettyPrint(child);
        }
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
