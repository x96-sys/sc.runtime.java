package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Transmission(Optional<Activity> activity, Optional<Nerve> nerve) implements Nerve {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s ()%n", indent, label());
        String child = " ".repeat(4) + indent;
        activity.ifPresent(a -> a.prettyPrint(child));
        nerve.ifPresent(n -> n.prettyPrint(child));
    }

    public Signal[] signals() {
        if (activity.isPresent()) {
            return activity.get().signal();
        }
        return new Signal[0];
    }

    public boolean empty() {
        return a() || b();
    }

    private boolean b() {
        return activity.map(value -> value.signal().length == 0).orElse(true);
    }

    private boolean a() {
        return activity.isEmpty() && nerve.isEmpty();
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
