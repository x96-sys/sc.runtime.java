package org.x96.sys.sc.ir.synthetic;

public record Activity(Signal[] signal) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        for (Signal s : signal) {
            s.prettyPrint(child);
        }
    }
}
