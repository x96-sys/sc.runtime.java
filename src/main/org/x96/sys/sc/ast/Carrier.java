package org.x96.sys.sc.ast;

import java.util.Optional;

public record Carrier(Optional<Brood> brood, Optional<Course> course) implements Course {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        brood.ifPresent(b -> b.prettyPrint(child));
        course.ifPresent(c -> c.prettyPrint(child));
    }
}
