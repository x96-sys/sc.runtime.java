package org.x96.sys.sc.ir.synthetic;

public sealed interface Signal extends ScIr permits Serie, Impulse, Text, Id, Schema, Nb16 {
}
