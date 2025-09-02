package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Pollinate;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Hipocampos;
import org.x96.sys.sc.ir.synthetic.Id;
import org.x96.sys.sc.ir.synthetic.Nature;
import org.x96.sys.sc.ir.synthetic.Signal;

import java.util.Optional;

public class PollinateToHipocampos implements ToIr<Pollinate, Hipocampos> {
    @Override
    public Hipocampos convert(Pollinate pollinate) {
        Nature nature = new FlowerToNature().convert(pollinate.flower());
        Id id = new PrimorToId().convert(pollinate.primor());
        Optional<Signal> signal = Optional.empty();
        if (pollinate.nectar().isPresent()){
            signal = Optional.of(new NectarToSignal().convert(pollinate.nectar().get()));
        }
        return new Hipocampos(nature, id, signal);
    }
}
