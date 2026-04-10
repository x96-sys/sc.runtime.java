package org.x96.sys.sc.ast;

public record Nucleotide(Primor primor, Fly fly) implements ScTree {

    @Override
    public void prettyPrint(String indent) {
        throw new RuntimeException("me implemente");
    }
}
