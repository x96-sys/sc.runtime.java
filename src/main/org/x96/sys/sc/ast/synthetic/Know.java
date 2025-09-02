package org.x96.sys.sc.ast.synthetic;

public record Know(Primor primor) implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException("Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
