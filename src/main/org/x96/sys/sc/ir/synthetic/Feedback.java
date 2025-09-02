package org.x96.sys.sc.ir.synthetic;

public record Feedback(Stimulus stimulus) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException("Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
