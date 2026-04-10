package org.x96.sys.sc.ast;

import java.util.Optional;

public record Fly(Forager forager, Optional<Course> course) implements Nectar, Behavior {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        forager.prettyPrint(child);
        course.ifPresent(c -> c.prettyPrint(child));
    }
}
