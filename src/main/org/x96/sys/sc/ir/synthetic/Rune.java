package org.x96.sys.sc.ir.synthetic;

public record Rune(Id id, Id[] insignias) implements Organelle {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s [%d] %n", indent, label(), new String(id.raw()), insignias.length);
        String child = " ".repeat(4) + indent;
        for (Id i : insignias) {
            i.prettyPrint(child);
        }
    }
}
