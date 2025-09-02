package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Fly;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Impulse;
import org.x96.sys.sc.ir.synthetic.Nerve;
import org.x96.sys.sc.ir.synthetic.Neuron;

import java.util.Optional;

public class FlyToImpulse implements ToIr<Fly, Impulse> {
    @Override
    public Impulse convert(Fly fly) {

        Neuron neuron = new ForagerToNeuron().convert(fly.forager());
        Optional<Nerve> nerve = Optional.empty();
        if (fly.course().isPresent()){
            nerve = Optional.of(new CourseToNerve().convert(fly.course().get()));
        }
        return new Impulse(neuron, nerve);
    }
}
