package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Filament;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Serie;

public class FilamentToSerie implements ToIr<Filament, Serie> {
    @Override
    public Serie convert(Filament filament) {
        Id[] ids = new Id[filament.primor().length];
        for (int i = 0; i < filament.primor().length; i++) {
            ids[i] = new PrimorToId().convert(filament.primor()[i]);
        }
        return new Serie(ids);
    }
}
