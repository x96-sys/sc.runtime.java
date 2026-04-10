package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

import java.util.Optional;

public record Neurotransmitter(Formula[] formulas, Optional<AminoAcid> aminoAcid, Isoform isoform)
        implements ScIr {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        aminoAcid.ifPresent(a -> a.prettyPrint(child));
        isoform.prettyPrint(child);
        for (Formula f : formulas) {
            f.prettyPrint(child);
        }
    }

    public boolean isSplat() {
        for (Formula f : formulas) {
            if (f == Formula.SPLAT) {
                return true;
            }
        }
        return false;
    }

    public boolean isOptional() {
        for (Formula f : formulas) {
            if (f == Formula.OPTIONAL) {
                return true;
            }
        }
        return false;
    }

    public boolean isArray() {
        for (Formula f : formulas) {
            if (f == Formula.ARRAY) {
                return true;
            }
        }
        return false;
    }

    public String aminoAcidName() {
        if (aminoAcid().isPresent()) {
            AminoAcid a = aminoAcid().get();
            if (a.id().isPresent()) {
                return new String(a.id().get().raw());
            }
        }
        return new String(isoform().id().raw()).toLowerCase();
    }

    @Override
    public String accept(EmitterVisitor visitor, String indent) {
        return visitor.visit(this, indent);
    }
}
