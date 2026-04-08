package org.x96.sys.sc.ir;

import org.x96.sys.sc.emit.EmitterVisitor;

public interface Visitable {
    String accept(EmitterVisitor visitor, String indent);
}
