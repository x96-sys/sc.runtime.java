package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Anatomy;
import org.x96.sys.sc.ast.Behavior;
import org.x96.sys.sc.ast.Genome;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Network;

public class GenomeToNetwork implements ToIr<Genome, Network> {
    @Override
    public Network convert(Genome genome) {
        return switch (genome) {
            case Anatomy anatomy -> new AnatomyToOrganelle().convert(anatomy);
            case Behavior behavior -> new BehaviorToStimulus().convert(behavior);
        };
    }
}
