package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Pollinate;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Hippocampus;
import org.x96.sys.sc.ir.Id;
import org.x96.sys.sc.ir.Nature;
import org.x96.sys.sc.ir.Signal;

import java.util.Optional;

public class PollinateToHipocampos implements ToIr<Pollinate, Hippocampus> {
    @Override
    public Hippocampus convert(Pollinate pollinate) {
        Nature nature = new FlowerToNature().convert(pollinate.flower());
        Id id = new PrimorToId().convert(pollinate.primor());
        Optional<Signal> signal = Optional.empty();
        if (pollinate.nectar().isPresent()) {
            signal = Optional.of(new NectarToSignal().convert(pollinate.nectar().get()));
        }
        return new Hippocampus(nature, id, signal);
    }
}
