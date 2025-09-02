package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Hipocampos(Nature nature, Id id, Optional<Signal> signal) implements Stimulus {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        nature.prettyPrint(child);
        id.prettyPrint(child);
        signal.ifPresent(s -> s.prettyPrint(child));
    }
}
