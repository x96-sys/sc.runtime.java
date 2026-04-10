package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Filament;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Axoneme;
import org.x96.sys.sc.ir.Id;
import org.x96.sys.sc.ir.Serial;
import org.x96.sys.sc.ir.Serie;

import java.util.Optional;

public class FilamentToSerie implements ToIr<Filament, Serie> {
    @Override
    public Serie convert(Filament filament) {
        Serial[] serialized = new Id[filament.rna().length];
        for (int i = 0; i < filament.rna().length; i++) {
            serialized[i] = new RnaToSerial().convert(filament.rna()[i]);
        }
        Optional<Axoneme> axoneme = Optional.empty();
        if (filament.base().isPresent()) {
            axoneme = Optional.of(new BaseToAxoneme().convert(filament.base().get()));
        }
        return new Serie(axoneme, serialized);
    }
}
