package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Signature;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Flow;
import org.x96.sys.sc.ir.synthetic.Neurotransmitter;
import org.x96.sys.sc.ir.synthetic.Schema;

import java.util.Optional;

public class SignatureToSchema implements ToIr<Signature, Schema> {
    @Override
    public Schema convert(Signature signature) {
        Neurotransmitter[] neurotransmitters = new Neurotransmitter[signature.pairs().length];
        for (int i = 0; i < signature.pairs().length; i++) {
            neurotransmitters[i] = new PairToNeurotransmitter().convert(signature.pairs()[i]);
        }
        Optional<Flow> flow = Optional.empty();
        if (signature.resonance().isPresent()){
            flow = Optional.of(new ResonanceToFlow().convert(signature.resonance().get()));
        }
        return new Schema(neurotransmitters, flow);
    }
}
