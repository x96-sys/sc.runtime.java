package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Echo;
import org.x96.sys.sc.ast.Forager;
import org.x96.sys.sc.ast.Hex;
import org.x96.sys.sc.ast.Ipse;
import org.x96.sys.sc.ast.Primor;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Endo;
import org.x96.sys.sc.ir.Neuron;

public class ForagerToNeuron implements ToIr<Forager, Neuron> {
    @Override
    public Neuron convert(Forager forager) {
        return switch (forager) {
            case Primor primor -> new PrimorToId().convert(primor);
            case Ipse ipse -> new Endo(ipse.raw());
            case Echo echo -> new EchoToText().convert(echo);
            case Hex hex -> new HexToNb16().convert(hex);
        };
    }
}
