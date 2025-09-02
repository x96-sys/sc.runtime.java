package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Transmission(Optional<Activity> activity, Optional<Nerve> nerve) implements Nerve {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s ()%n", indent, label());
        String child = " ".repeat(4) + indent;
        activity.ifPresent(a -> a.prettyPrint(child));
        nerve.ifPresent(n -> n.prettyPrint(child));
    }
}
