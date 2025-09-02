package org.x96.sys.sc.ir.synthetic;

import java.util.Optional;

public record Neurotransmitter(Optional<AminoAcid> aminoAcid, Isoform isoform) implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        aminoAcid.ifPresent(a -> a.prettyPrint(child));
        isoform.prettyPrint(child);
    }
}
