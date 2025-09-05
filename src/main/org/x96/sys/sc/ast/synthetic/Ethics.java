package org.x96.sys.sc.ast.synthetic;

import java.util.Optional;

public record Ethics(Primor primor, Optional<Signature> signature, Optional<Manifest> manifest) implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
        signature.ifPresent(s -> s.prettyPrint(child));
        manifest.ifPresent(m -> m.prettyPrint(child));
    }
}
