package org.x96.sys.sc.ir.synthetic;

import org.x96.sys.sc.ast.synthetic.ScTree;

public record Egg(Network[] network) implements ScTree {
    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        String child = " ".repeat(4) + indent;
        for (Network n : network) {
            n.prettyPrint(child);
        }
    }
}
