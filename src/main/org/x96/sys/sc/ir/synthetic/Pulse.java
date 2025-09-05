package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Pulse(Id id, Optional<Schema> schema, Optional<Chemical> chemical) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), new String(id.raw()));
        String child = " ".repeat(4) + indent;
        schema.ifPresent(s -> s.prettyPrint(child));
        chemical.ifPresent(f -> f.prettyPrint(child));
    }
}
