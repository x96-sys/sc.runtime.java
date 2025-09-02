package org.x96.sys.sc.ast.synthetic;

public record Manifest(Behavior behavior) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException("Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
