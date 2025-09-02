package org.x96.sys.sc.ir.synthetic;


public enum Nature implements ScIr {
    MUTABLE, STATIC
    ;
    public String h(){
        return switch (this) {
            case MUTABLE -> "mutable";
            case STATIC -> "static";
        };
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > [%s]%n", indent, label(), h());

    }
}
