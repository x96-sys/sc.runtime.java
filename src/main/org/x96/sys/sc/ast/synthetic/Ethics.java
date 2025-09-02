package org.x96.sys.sc.ast.synthetic;

import java.util.Optional;

public record Ethics(Primor primor, Optional<Signature> signature, Optional<Manifest> manifest) implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException("Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
