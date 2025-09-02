package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Pulse(Id id, Optional<Schema> schema, Optional<Feedback> feedback) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        throw new UnsupportedOperationException("Unimplemented method 'prettyPrint' on " + getClass().getSimpleName());
    }
}
