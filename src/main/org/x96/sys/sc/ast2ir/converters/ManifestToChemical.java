package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Manifest;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Chemical;

public class ManifestToChemical implements ToIr<Manifest, Chemical> {
    @Override
    public Chemical convert(Manifest manifest) {
        return new Chemical(new BehaviorToStimulus().convert(manifest.behavior()));
    }
}
