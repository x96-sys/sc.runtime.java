package org.x96.sys.sc.ir;

public sealed interface Neuron extends ScIr permits Id, Endo, Text, Nb16 {
    default boolean isId() {
        return this instanceof Id;
    }

    default boolean isPrimitive() {
        return switch (this) {
            case Endo endo -> false;
            case Id id ->
                    switch (new String(id.raw()).toLowerCase()) {
                        case "echo", "hex" -> true;
                        default -> false;
                    };
            case Nb16 nb16 -> true;
            case Text text -> true;
        };
    }

    // Like Neuron.class
    default Id bug() {
        switch (this) {
            case Endo endo -> {
                throw new RuntimeException("me implemente: seu pai, garoto");
            }
            case Id id -> {
                return id;
            }
            case Nb16 nb16 -> {
                return new Id("Hex".getBytes()); // primitive type
            }
            case Text text -> {
                return new Id("Echo".getBytes()); // primitive type
            }
        }
    }
}
