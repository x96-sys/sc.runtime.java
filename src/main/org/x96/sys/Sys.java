package org.x96.sys;

import org.x96.sys.sc.ir.*;

public class Sys {
    public static Class<? extends ScIr> is(Neuron neuron) {
        return switch (neuron) {
            case Endo endo -> throw new RuntimeException("me implemente");
            case Id id -> throw new RuntimeException("me implemente");
            case Nb16 nb16 -> Nb16.class;
            case Text text -> Text.class;
        };
    }

    public static String kind(Impulse impulse) {
        return switch (impulse.neuron()) {
            case Endo endo -> throw new RuntimeException("me implemente");
            case Id id -> throw new RuntimeException("me implemente");
            case Nb16 nb16 -> "Hex";
            case Text text -> "Echo";
        };
    }

    public static boolean matchKind() {
        return false;
    }
}
