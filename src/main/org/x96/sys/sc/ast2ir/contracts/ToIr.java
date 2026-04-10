package org.x96.sys.sc.ast2ir.contracts;

import org.x96.sys.sc.ast.ScTree;
import org.x96.sys.sc.ir.ScIr;

public interface ToIr<T extends ScTree, R extends ScIr> {
    R convert(T ast);
}
