package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Logos;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Swarm;

public class LogosToSwarm implements ToIr<Logos, Swarm> {
    @Override
    public Swarm convert(Logos ast) {
        return new Swarm(new PrimorToId().convert(ast.primor()));
    }
}
