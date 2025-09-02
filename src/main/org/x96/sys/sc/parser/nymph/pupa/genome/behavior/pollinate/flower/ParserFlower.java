package org.x96.sys.sc.parser.nymph.pupa.genome.behavior.pollinate.flower;

import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Flower;
import org.x96.sys.sc.parser.Parser;

public class ParserFlower extends Parser<Flower> {
    public ParserFlower(Tape tape) {
        super(tape);
    }

    @Override
    public Flower parse() {
        if (hasNext("flower")) {
            int value = consume("flower").lexeme().b();
            return switch (value) {
                case 0x40 -> Flower.VARIABLE;
                case 0x25 -> Flower.CONSTANT;
                default -> throw new IllegalArgumentException(
                        "Unexpected flower token: 0x" + Integer.toHexString(value)
                );
            };
        }
        throw new IllegalStateException("Expected token 'flower' but none found");
    }
}
