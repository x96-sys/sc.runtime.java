package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Anatomy;
import org.x96.sys.sc.ast.synthetic.Behavior;
import org.x96.sys.sc.ast.synthetic.Genome;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Network;

public class GenomeToNetwork implements ToIr<Genome, Network> {
    @Override
    public Network convert(Genome genome) {
        return switch (genome) {
            case Anatomy anatomy -> new AnatomyToOrganelle().convert(anatomy);
            case Behavior behavior -> new BehaviorToStimulus().convert(behavior);
        };
    }
}
