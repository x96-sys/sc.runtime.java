package org.x96.sys.sc.ast;

public record Skill(Primor primor, Ethics[] ethics) implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        primor.prettyPrint(child);
        for (Ethics e : ethics) {
            e.prettyPrint(child);
        }
    }
}
