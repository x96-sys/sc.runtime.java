package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Carrier;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Activity;
import org.x96.sys.sc.ir.synthetic.Nerve;
import org.x96.sys.sc.ir.synthetic.Transmission;

import java.util.Optional;

public class CarrierToTransmission implements ToIr<Carrier, Transmission> {
    @Override
    public Transmission convert(Carrier carrier) {
        Optional<Activity> activity = Optional.empty();
        if (carrier.brood().isPresent()){
            activity = Optional.of(new BroodToActivity().convert(carrier.brood().get()));
        }
        Optional<Nerve > nerve = Optional.empty();
        return new Transmission(activity, nerve);
    }
}
