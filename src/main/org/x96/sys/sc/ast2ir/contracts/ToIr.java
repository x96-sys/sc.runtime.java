package org.x96.sys.sc.ast2ir.contracts;

public interface ToIr<T, R> {
    R convert(T ast);
}
