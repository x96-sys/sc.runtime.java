package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Signature;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Neurotransmitter;
import org.x96.sys.sc.ir.Schema;

public class SignatureToSchema implements ToIr<Signature, Schema> {
    @Override
    public Schema convert(Signature signature) {
        Neurotransmitter[] neurotransmitters = new Neurotransmitter[signature.pairs().length];
        for (int i = 0; i < signature.pairs().length; i++) {
            neurotransmitters[i] = new PairToNeurotransmitter().convert(signature.pairs()[i]);
        }
        return new Schema(neurotransmitters);
    }
}
