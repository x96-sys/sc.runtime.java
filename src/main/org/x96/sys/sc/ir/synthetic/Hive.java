package org.x96.sys.sc.ir.synthetic;

public record Hive(Egg egg) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        egg.prettyPrint(child);
    }
}
