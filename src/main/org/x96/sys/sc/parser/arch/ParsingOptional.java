package org.x96.sys.sc.parser.arch;

import org.x96.sys.sc.ast.ScTree;

import java.util.Optional;

public interface ParsingOptional<T extends ScTree> {
    public Optional<T> parse();
}
