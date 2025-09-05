package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Ethics;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Chemical;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Pulse;
import org.x96.sys.sc.ir.synthetic.Schema;

import java.util.Optional;

public class EthicsToPulse implements ToIr<Ethics, Pulse> {
    @Override
    public Pulse convert(Ethics ethics) {
        Id id = new PrimorToId().convert(ethics.primor());
        Optional<Schema> schema = Optional.empty();
        if (ethics.signature().isPresent()){
            schema = Optional.of(new SignatureToSchema().convert(ethics.signature().get()));
        }
        Optional<Chemical> feedback = Optional.empty();
        if (ethics.manifest().isPresent()){
            feedback = Optional.of(new ManifestToChemical().convert(ethics.manifest().get()));
        }
        return new Pulse(id, schema, feedback);
    }
}
