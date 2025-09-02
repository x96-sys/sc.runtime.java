package org.x96.sys.sc.ast.synthetic;

public enum ModTypo {
    ARRAY, OPTIONAL

    ;
    public String h(){
        return switch (this) {
            case ARRAY -> "[]";
            case OPTIONAL -> "?";
        };
    }
}
