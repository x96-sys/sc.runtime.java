package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.*;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Signal;

public class NectarToSignal implements ToIr<Nectar, Signal> {
    @Override
    public Signal convert(Nectar nectar) {
        return switch (nectar) {
            case Filament filament -> new FilamentToSerie().convert(filament);
            case Fly fly -> new FlyToImpulse().convert(fly);
            case Brood brood -> new BroodToActivity().convert(brood);
            case Aura aura -> new AuraToWave().convert(aura);
        };
    }
}
