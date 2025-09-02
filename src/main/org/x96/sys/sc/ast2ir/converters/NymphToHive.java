package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Nymph;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Hive;

public class NymphToHive implements ToIr<Nymph, Hive> {
    @Override
    public Hive convert(Nymph nymph) {
        return new Hive(new PupaToEgg().convert(nymph.pupa()));
    }
}
