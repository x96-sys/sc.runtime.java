package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Norte;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Direction;
import org.x96.sys.sc.ir.Schema;

import java.util.Optional;

public class NorteToDirection implements ToIr<Norte, Direction> {
    @Override
    public Direction convert(Norte norte) {
        Optional<Schema> schema = Optional.empty();
        if (norte.signature().isPresent()) {
            schema = Optional.of(new SignatureToSchema().convert(norte.signature().get()));
        }
        return new Direction(new PrimorToId().convert(norte.primor()), schema);
    }
}
