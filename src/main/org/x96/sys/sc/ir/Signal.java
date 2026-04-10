package org.x96.sys.sc.ir;

public sealed interface Signal extends ScIr permits Serie, Impulse, Wave, Activity {}
