package org.x96.sys.sc.ast;

public record As(Primor primor) implements Tie {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException(
                "Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
