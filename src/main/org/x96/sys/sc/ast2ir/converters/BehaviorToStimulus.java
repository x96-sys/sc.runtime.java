package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Behavior;
import org.x96.sys.sc.ast.Fly;
import org.x96.sys.sc.ast.Pollinate;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Stimulus;

public class BehaviorToStimulus implements ToIr<Behavior, Stimulus> {
    @Override
    public Stimulus convert(Behavior behavior) {
        return switch (behavior) {
            case Fly fly -> new FlyToImpulse().convert(fly);
            case Pollinate pollinate -> new PollinateToHipocampos().convert(pollinate);
        };
    }
}
