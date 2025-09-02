package org.x96.sys.sc.ir.synthetic;

public record Bee(Id id, Pulse[] pulses) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        id.prettyPrint(child);
        for (Pulse p : pulses) {
            p.prettyPrint(child);
        }
    }
}
