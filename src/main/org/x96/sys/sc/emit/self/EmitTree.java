package org.x96.sys.sc.emit.self;

import org.x96.sys.sc.emit.arch.Emit;
import org.x96.sys.sc.emit.self.hive.EmitHive;
import org.x96.sys.sc.ir.synthetic.Tree;

public class EmitTree extends Emit<Tree> {
    public EmitTree(Tree tree) {
        super(tree);
    }

    @Override
    public String toSC() {
        return new EmitHive(t.hive()).toSC();
    }
}
