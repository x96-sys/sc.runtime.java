package org.x96.sys.sc.ast.synthetic;

public enum Flower {
    VARIABLE, CONSTANT
    ;
    public String h(){
        return switch (this) {
            case VARIABLE -> "@";
            case CONSTANT -> "%";
        };
    }
}
