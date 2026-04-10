package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Sc;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Tree;

public class ScToTree implements ToIr<Sc, Tree> {

    @Override
    public Tree convert(Sc sc) {
        return new Tree(new NymphToHive().convert(sc.nymph()));
    }
}
