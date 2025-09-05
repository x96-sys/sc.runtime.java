package org.x96.sys.sc.ast.synthetic;

public record Totem(Primor primor, Primor[] primes, Ethics[] ethics) implements Anatomy {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s [%d]%n", indent, label(), new String(primor.raw()), primes.length);
        String child = " ".repeat(4) + indent;
        for (Primor p : primes) {
            p.prettyPrint(child);
        }
        for (Ethics e : ethics) {
            e.prettyPrint(child);
        }
    }
}
