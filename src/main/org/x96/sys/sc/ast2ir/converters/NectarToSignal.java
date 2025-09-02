package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.*;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Signal;

public class NectarToSignal implements ToIr<Nectar, Signal> {
    @Override
    public Signal convert(Nectar nectar) {
        return switch (nectar) {
            case Echo echo -> new EchoToText().convert(echo);
            case Filament filament -> new FilamentToSerie().convert(filament);
            case Fly fly -> new FlyToImpulse().convert(fly);
            case Primor primor -> new PrimorToId().convert(primor);
            case Signature signature -> new SignatureToSchema().convert(signature);
        };
    }
}
