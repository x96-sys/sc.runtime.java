package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Totem;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Bundle;
import org.x96.sys.sc.ir.Direction;
import org.x96.sys.sc.ir.Pulse;
import org.x96.sys.sc.ir.Rune;

import java.util.Optional;

public class TotemToRune implements ToIr<Totem, Rune> {
    @Override
    public Rune convert(Totem totem) {
        Direction[] directions = new Direction[totem.nortes().length];
        for (int i = 0; i < totem.nortes().length; i++) {
            directions[i] = new NorteToDirection().convert(totem.nortes()[i]);
        }
        Pulse[] pulses = new Pulse[totem.ethics().length];
        for (int i = 0; i < totem.ethics().length; i++) {
            pulses[i] = new EthicsToPulse().convert(totem.ethics()[i]);
        }

        Optional<Bundle> bundle = Optional.empty();
        if (totem.generalization().isPresent()) {
            bundle =
                    Optional.of(new GeneralizationToBundle().convert(totem.generalization().get()));
        }

        return new Rune(new PrimorToId().convert(totem.primor()), directions, pulses, bundle);
    }
}
