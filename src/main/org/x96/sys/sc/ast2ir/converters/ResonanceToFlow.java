package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Generalization;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast.Ready;
import org.x96.sys.sc.ast.Resonance;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Flow;

public class ResonanceToFlow implements ToIr<Resonance, Flow> {
    @Override
    public Flow convert(Resonance resonance) {
        return switch (resonance) {
            case Primor primor -> new PrimorToId().convert(primor);
            case Ready ready -> new ReadyToLife().convert(ready);
            case Generalization generalization ->
                    new GeneralizationToBundle().convert(generalization);
        };
    }
}
