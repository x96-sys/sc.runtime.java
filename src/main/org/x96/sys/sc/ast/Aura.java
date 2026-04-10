package org.x96.sys.sc.ast;

import java.util.Optional;

public record Aura(Signature signature, Optional<Resonance> resonance) implements Nectar {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        signature.prettyPrint(child);
        resonance.ifPresent(r -> r.prettyPrint(child));
    }
}
