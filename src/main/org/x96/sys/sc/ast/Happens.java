package org.x96.sys.sc.ast;

public record Happens(Nucleotide[] nucleotides) implements Course {
    @Override
    public void prettyPrint(String indent) {
        throw new RuntimeException("me implemente");
    }
}
