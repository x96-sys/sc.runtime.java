package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.synthetic.Attribute;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.synthetic.AminoAcid;
import org.x96.sys.sc.ir.synthetic.Id;

import java.util.Optional;

public class AttributeToAminoAcid implements ToIr<Attribute, AminoAcid> {
    @Override
    public AminoAcid convert(Attribute attribute) {
        Optional<Id> id = Optional.empty();
        if (attribute.primor().isPresent()) {
            id = Optional.of(new PrimorToId().convert(attribute.primor().get()));
        }
        return new AminoAcid(attribute.splat(), id);
    }
}
