package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Abstraction;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Bond;
import org.x96.sys.sc.ir.Packet;

import java.util.Optional;

public class AbstractionToPacket implements ToIr<Abstraction, Packet> {
    @Override
    public Packet convert(Abstraction abstraction) {
        Optional<Bond> bond = abstraction.tie().map(tie -> new TieToBond().convert(tie));
        return new Packet(new PrimorToId().convert(abstraction.primor()), bond);
    }
}
