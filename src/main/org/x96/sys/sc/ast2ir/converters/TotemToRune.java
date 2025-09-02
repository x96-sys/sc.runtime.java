package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Totem;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Rune;

public class TotemToRune implements ToIr<Totem, Rune> {
    @Override
    public Rune convert(Totem totem) {
        Id[] insignias = new Id[totem.primes().length];
        for (int i = 0; i < totem.primes().length; i++) {
            insignias[i] = new PrimorToId().convert(totem.primes()[i]);
        }
        return new Rune(new PrimorToId().convert(totem.primor()), insignias);
    }
}
