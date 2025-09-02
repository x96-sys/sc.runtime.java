package org.x96.sys.sc.ir.synthetic;

public record Connect(Id id) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException("Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
