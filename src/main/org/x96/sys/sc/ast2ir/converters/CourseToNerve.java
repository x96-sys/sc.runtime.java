package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Carrier;
import org.x96.sys.sc.ast.synthetic.Catalysis;
import org.x96.sys.sc.ast.synthetic.Course;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.Nerve;

public class CourseToNerve implements ToIr<Course, Nerve> {
    @Override
    public Nerve convert(Course course) {
        return switch (course) {
            case Carrier carrier -> new CarrierToTransmission().convert(carrier);
            case Catalysis catalysis -> new CatalysisToSynaptic().convert(catalysis);
        };
    }
}
