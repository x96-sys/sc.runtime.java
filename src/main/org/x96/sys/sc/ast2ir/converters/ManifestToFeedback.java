package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Manifest;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Feedback;

public class ManifestToFeedback implements ToIr<Manifest, Feedback> {
    @Override
    public Feedback convert(Manifest manifest) {
        return new Feedback(new BehaviorToStimulus().convert(manifest.behavior()));
    }
}
