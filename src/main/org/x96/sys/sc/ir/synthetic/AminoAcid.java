package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record AminoAcid(boolean splat, Optional<Id> id) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        String splat = String.format("%s", this.splat ? " [*]" : "");
        System.out.printf("%s%s%s%n", indent, label(), splat);
        String child = " ".repeat(4) + indent;
        id.ifPresent(i -> i.prettyPrint(child));
    }
}
