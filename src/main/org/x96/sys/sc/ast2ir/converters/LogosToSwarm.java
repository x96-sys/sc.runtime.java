package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Logos;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Swarm;

public class LogosToSwarm implements ToIr<Logos, Swarm> {
    @Override
    public Swarm convert(Logos logos) {
        return new Swarm(new PrimorToId().convert(logos.web()));
    }
}
