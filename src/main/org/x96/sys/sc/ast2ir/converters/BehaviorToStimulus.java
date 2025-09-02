package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Behavior;
import org.x96.sys.sc.ast.synthetic.Fly;
import org.x96.sys.sc.ast.synthetic.Pollinate;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Stimulus;

public class BehaviorToStimulus implements ToIr<Behavior, Stimulus> {
    @Override
    public Stimulus convert(Behavior behavior) {
        return switch (behavior) {
            case Fly fly -> new FlyToImpulse().convert(fly);
            case Pollinate pollinate -> new PollinateToHipocampos().convert(pollinate);
        };
    }
}
