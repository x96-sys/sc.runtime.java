package org.x96.sys.sc.ast.synthetic;

public record Pupa(Genome[] genome) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s [%d]%n", indent, label(), genome.length);
        String child = " ".repeat(4) + indent;
        for (Genome g : genome) {
            g.prettyPrint(child);
        }
    }
}
