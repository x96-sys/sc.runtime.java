package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Catalysis;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Nerve;
import org.x96.sys.sc.ir.synthetic.Synaptic;

import java.util.Optional;

public class CatalysisToSynaptic implements ToIr<Catalysis, Synaptic> {
    @Override
    public Synaptic convert(Catalysis catalysis) {
        Id id = new PrimorToId().convert(catalysis.primor());
        Optional<Nerve > nerve = Optional.empty();
        if (catalysis.course().isPresent()){
            nerve = Optional.of(new CourseToNerve().convert(catalysis.course().get()));
        }
        return new Synaptic(id, nerve);
    }
}
