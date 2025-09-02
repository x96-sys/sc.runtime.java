package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Pupa;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Bee;
import org.x96.sys.sc.ir.synthetic.Egg;
import org.x96.sys.sc.ir.synthetic.Network;

public class PupaToEgg implements ToIr<Pupa, Egg> {
    @Override
    public Egg convert(Pupa pupa) {
        Network[] network = new Network[pupa.genome().length];
        for (int i = 0; i < pupa.genome().length; i++) {
            network[i] = new GenomeToNetwork().convert(pupa.genome()[i]);
        }
        return new Egg(network);
    }
}
