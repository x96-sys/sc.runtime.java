package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Aura;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Flow;
import org.x96.sys.sc.ir.Wave;

import java.util.Optional;

public class AuraToWave implements ToIr<Aura, Wave> {
    @Override
    public Wave convert(Aura aura) {
        Optional<Flow> flow = Optional.empty();
        if (aura.resonance().isPresent()) {
            flow = Optional.of(new ResonanceToFlow().convert(aura.resonance().get()));
        }
        return new Wave(new SignatureToSchema().convert(aura.signature()), flow);
    }
}
