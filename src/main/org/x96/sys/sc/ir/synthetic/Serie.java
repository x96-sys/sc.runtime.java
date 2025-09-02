package org.x96.sys.sc.ir.synthetic;

public record Serie(Id[] ids) implements Signal {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), ids.length);
        String child = " ".repeat(4) + indent;
        for (Id i : ids) {
            i.prettyPrint(child);
        }
    }
}
