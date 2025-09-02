package org.x96.sys.sc.ast.synthetic;

import java.util.Optional;

public record Signature(Pair[] pairs, Optional<Resonance> resonance) implements Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), pairs.length);
        String child = " ".repeat(4) + indent;
        for (Pair p : pairs) {
            p.prettyPrint(child);
        }
        resonance.ifPresent(r -> r.prettyPrint(child));
    }
}
