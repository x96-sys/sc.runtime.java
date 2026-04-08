package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Manifest;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Chemical;
import org.x96.sys.sc.ir.Stimulus;

public class ManifestToChemical implements ToIr<Manifest, Chemical> {
    @Override
    public Chemical convert(Manifest manifest) {
        Stimulus[] s = new Stimulus[manifest.behavior().length];
        for (int i = 0; i < manifest.behavior().length; i++) {
            s[i] = new BehaviorToStimulus().convert(manifest.behavior()[i]);
        }
        return new Chemical(s);
    }
}
