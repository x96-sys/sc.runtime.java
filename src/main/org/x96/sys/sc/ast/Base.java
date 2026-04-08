package org.x96.sys.sc.ast;

public enum Base implements ScTree {
    PRIMOR,
    ECHO,
    NORTE;

    public String h() {
        return switch (this) {
            case PRIMOR -> "p";
            case ECHO -> "e";
            case NORTE -> "n";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        throw new RuntimeException("n estou pronto para isso");
    }
}
