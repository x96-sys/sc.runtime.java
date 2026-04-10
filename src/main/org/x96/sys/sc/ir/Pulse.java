package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Objects;
import java.util.Optional;

public record Pulse( // method
        Id id, // name
        Optional<Schema> schema, // signature
        Optional<Flow> flow, // return
        Optional<Chemical> chemical // implementation
        ) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), new String(id.raw()));
        String child = " ".repeat(4) + indent;
        schema.ifPresent(s -> s.prettyPrint(child));
        flow.ifPresent(f -> f.prettyPrint(child));
        chemical.ifPresent(f -> f.prettyPrint(child));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pulse pulse = (Pulse) obj;
        return Objects.equals(id, pulse.id)
                && Objects.equals(schema, pulse.schema)
                && Objects.equals(flow, pulse.flow)
                && Objects.equals(chemical, pulse.chemical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schema, chemical);
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
