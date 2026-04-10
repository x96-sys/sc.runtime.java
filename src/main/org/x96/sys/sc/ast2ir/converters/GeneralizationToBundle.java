package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Generalization;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Bundle;
import org.x96.sys.sc.ir.Packet;

public class GeneralizationToBundle implements ToIr<Generalization, Bundle> {
    @Override
    public Bundle convert(Generalization generalization) {
        Packet[] packets = new Packet[generalization.abstractions().length];
        for (int i = 0; i < generalization.abstractions().length; i++) {
            packets[i] = new AbstractionToPacket().convert(generalization.abstractions()[i]);
        }
        return new Bundle(packets);
    }
}
