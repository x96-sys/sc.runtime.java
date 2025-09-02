package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Primor;
import org.x96.sys.sc.ast.synthetic.Ready;
import org.x96.sys.sc.ast.synthetic.Resonance;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Flow;

public class ResonanceToFlow implements ToIr<Resonance, Flow> {
    @Override
    public Flow convert(Resonance resonance) {
        return switch (resonance) {
            case Primor primor -> new PrimorToId().convert(primor);
            case Ready ready -> new ReadyToLife().convert(ready);
        };
    }
}
