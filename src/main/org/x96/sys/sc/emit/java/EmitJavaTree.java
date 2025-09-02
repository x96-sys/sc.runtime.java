package org.x96.sys.sc.emit.java;


import org.x96.sys.sc.emit.java.arch.Emit;
import org.x96.sys.sc.emit.self.hive.EmitHive;
import org.x96.sys.sc.ir.synthetic.Tree;

public class EmitJavaTree extends Emit<Tree> {
    public EmitJavaTree(Tree t) {
        super(t);
    }

    @Override
    public String toJava() {
        return new EmitHive(t.hive()).toSC();
    }
}
