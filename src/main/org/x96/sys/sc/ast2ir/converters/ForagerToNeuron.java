package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Forager;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Neuron;

public class ForagerToNeuron implements ToIr<Forager, Neuron> {
    @Override
    public Neuron convert(Forager forager) {
        return new Neuron(forager.self(), new PrimorToId().convert(forager.primor()));
    }
}
