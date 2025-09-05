package org.x96.sys.sc.parser;

import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;

public abstract class Parser<T> extends org.x96.sys.parser.Parser implements Parsing<T> {
    public Parser(Tape tape) {
        super(tape);
    }

    public void skipSpace() {
        if (hasNext("space")) {
            consume("space");
            skipSpace();
        }
    }

    public void skip(String s) {
        if (hasNext(s)) {
            consume(s);
            skip(s);
        }
    }

    public void skipI() {
        if (hasNext("i")) {
            consume("i");
            skipI();
        }
    }

    public void skipPS() {
        if (hasNext("ps")) {
            consume("ps");
        }
    }

    public boolean hasNextFilament() {
        return hasNext("filament");
    }

    public boolean hasNextBrood() {
        return  hasNextPrimorLiteral() || hasNextHex() || hasNextFly();
    }

    public boolean hasNextPrimorLiteral() {
        return hasNext("primor_literal");
    }

    public boolean hasNextCatalysis() {
        return hasNext("catalysis");
    }

    public boolean hasNextCarrier() {
        return hasNext("init_carrier");
    }

    public boolean hasNextHex() {
        return hasNext("hex");
    }

    public boolean hasNextCourse() {
        if (hasNextCatalysis()) {
            return true;
        }
        if (hasNextCarrier()) {
            return true;
        }
        return false;
    }

    public boolean hasNextFly() {
        return hasNextPrimor() || hasNextSelf();
    }

    public boolean hasNextSelf() {
        return hasNext("self");
    }

    public boolean hasNextResonance() {
        if (hasNextVoid()) {
            return true;
        }
        if (hasNextPrimor()) {
            return true;
        }
        return false;
    }

    public boolean hasNextVoid() {
        return hasNext("void");
    }

    public boolean hasNextModTypo() {
        if (hasNextArray()) {
            return true;
        }
        if (hasNextOptional()) {
            return true;
        }
        return false;
    }

    public boolean hasNextPairFollow() {
        return hasNext("pair_follow");
    }

    public boolean hasNextPair() {
        if (hasNextAttribute()) {
            return true;
        }
        if (hasNextTypo()) {
            return true;
        }
        return false;
    }

    private boolean hasNextTypo() {
        if (hasNextArray()) {
            return true;
        }
        if (hasNextOptional()) {
            return true;
        }
        return false;
    }

    public boolean hasNextOptional() {
        return hasNext("optional");
    }

    public boolean hasNextArray() {
        return hasNext("array");
    }

    public boolean hasNextAttribute() {
        if (hasNextModAttribute()) {
            return true;
        }
        if (hasNextPrimor()) {
            return true;
        }
        return false;
    }

    public boolean hasNextModAttribute() {
        return hasNext("splat");
    }

    public boolean hasNextPrimor() {
        return hasNext("primor");
    }

    public boolean hasNextNectar() {
        return hasNextEcho()
                || hasNextSignature()
                || hasNextPrimorLiteral()
                || hasNextFly()
                || hasNextFilament()
                || hasNextHex();
    }

    public boolean hasNextSignature() {
        return hasNext("init_signature");
    }

    public boolean hasNextEcho() {
        return hasNext("echo");
    }

    public boolean hasNextGenome() {
        if (hasNextAnatomy()) {
            return true;
        }
        if (hasNextBehavior()) {
            return true;
        }
        return false;
    }

    public boolean hasNextAnatomy() {
        return hasNext("init_anatomy");
    }

    public boolean hasNextBehavior() {
        if (hasNextPollinate()) {
            return true;
        }
        if (hasNextFly()) {
            return true;
        }
        return false;
    }

    public boolean hasNextPollinate() {
        if (hasNext("flower")) {
            return true;
        }
        return false;
    }

    @Override
    public T parse() {
        throw new RuntimeException("deve ser implementado na classe filha");
    }
}
