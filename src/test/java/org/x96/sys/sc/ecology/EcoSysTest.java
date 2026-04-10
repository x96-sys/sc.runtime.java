package org.x96.sys.sc.ecology;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.IoTest.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.common.TRU;
import org.x96.sys.sc.ir.Id;

class EcoSysTest {
    @Test
    void happy() {
        EcoSys ecoSys = new EcoSys();
        assertNotNull(ecoSys);
        assertNull(ecoSys.buffTree);
        assertNotNull(ecoSys.biosphere);
        assertEquals(0, ecoSys.biosphere.biomes.size());
        assertNull(ecoSys.biosphere.dawning);
    }

    @Test
    void happyRise() {
        EcoSys ecoSys = new EcoSys();
        assertNotNull(ecoSys);
        assertNull(ecoSys.buffTree);
        assertNotNull(ecoSys.biosphere);
        assertEquals(0, ecoSys.biosphere.biomes.size());
        ecoSys.rise(new Id("main".getBytes()));
        assertEquals(1, ecoSys.biosphere.biomes.size());
        assertArrayEquals("main".getBytes(), ecoSys.biosphere.biome().bioName.raw());
        assertEquals(0, ecoSys.biosphere.biome().organisms.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.specimens.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.immortals.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.phenotypes.size());
    }

    @Test
    void happyRiseFromFront() {
        EcoSys ecoSys = new EcoSys();
        ecoSys.bioIntegrate(":logos org.x96.sys;".getBytes());
        assertEquals(1, ecoSys.biosphere.biomes.size());
        assertArrayEquals("org.x96.sys".getBytes(), ecoSys.biosphere.dawning.raw());
        assertArrayEquals("org.x96.sys".getBytes(), ecoSys.biosphere.biome().bioName.raw());
        assertEquals(0, ecoSys.biosphere.biome().organisms.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.specimens.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.immortals.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.phenotypes.size());
        ecoSys.bioIntegrate(":logos org.x96.sys.buzz;".getBytes());
        assertEquals(2, ecoSys.biosphere.biomes.size());
    }

    @Test
    void happyConstant() {
        EcoSys ecoSys = new EcoSys();
        ecoSys.rise(new Id("sys".getBytes()));
        ecoSys.bioIntegrate("%VERSION = '0.1.2';".getBytes());
        assertEquals(0, ecoSys.biosphere.biome().organisms.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.specimens.size());
        assertEquals(1, ecoSys.biosphere.biome().chronicle.immortals.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.phenotypes.size());
        assertPrintLn(
                """
                ☀️ [x96] [EcoSys] [SC]
                🪐 [biomes] [1]
                    🌍 [biome] [sys]
                        🐞 [organisms] [0]
                        🦄 [folklore] (0) {1} [0]
                            🐦‍🔥 [Echo] [VERSION] ['0.1.2']\
                """,
                () -> ecoSys.eco(""));

        assertEquals(
                """
                :logos sys;

                %VERSION = '0.1.2';\
                """,
                ecoSys.emit(EcoTarget.SC));
    }

    @Test
    void happyConstantRootGhost() {
        EcoSys ecoSys = new EcoSys();
        ecoSys.rise(new Id("".getBytes()));
        ecoSys.bioIntegrate("%VERSION = '0.1.2';".getBytes());
        assertEquals(0, ecoSys.biosphere.biome().organisms.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.specimens.size());
        assertEquals(1, ecoSys.biosphere.biome().chronicle.immortals.size());
        assertEquals(0, ecoSys.biosphere.biome().chronicle.phenotypes.size());
        assertPrintLn(
                """
                ☀️ [x96] [EcoSys] [SC]
                🪐 [biomes] [1]
                    🌍 [biome] []
                        🐞 [organisms] [0]
                        🦄 [folklore] (0) {1} [0]
                            🐦‍🔥 [Echo] [VERSION] ['0.1.2']\
                """,
                () -> ecoSys.eco(""));

        assertEquals("%VERSION = '0.1.2';", ecoSys.emit(EcoTarget.SC));
        assertEquals("@VERSION = constant [6 x i8] c\"0.1.2\\00\"", ecoSys.emit(EcoTarget.LLVM));
    }

    @Test
    void happyTotem() {
        EcoSys ecoSys = new EcoSys();
        ecoSys.rise(new Id("org.x96.sys".getBytes()));
        ecoSys.bioIntegrate(TRU.readInputBytes("b.sc"));

        assertEquals(1, ecoSys.biosphere.biome().organisms.size());
        assertPrintLn(
                """
                ☀️ [x96] [EcoSys] [SC]
                🪐 [biomes] [1]
                    🌍 [biome] [org.x96.sys]
                        🐞 [organisms] [1]
                        🦄 [folklore] (0) {0} [0]\
                """,
                () -> ecoSys.eco(""));

        // Test all target outputs using resources
        assertArrayEquals(TRU.rb("java", "totem"), ecoSys.emit(EcoTarget.JAVA).getBytes());
        assertEquals(TRU.r("java", "totem"), ecoSys.emit(EcoTarget.JAVA));
        assertArrayEquals(TRU.rb("zig", "totem"), ecoSys.emit(EcoTarget.ZIG).getBytes());
        assertArrayEquals(TRU.rb("ts", "totem"), ecoSys.emit(EcoTarget.TS).getBytes());
        assertArrayEquals(TRU.rb("puml", "totem"), ecoSys.emit(EcoTarget.PUML).getBytes());
        assertArrayEquals(TRU.rb("sc", "totem"), ecoSys.emit(EcoTarget.SC).getBytes());
    }

    @Test
    void happyBug() {
        EcoSys ecoSys = new EcoSys();
        ecoSys.rise(new Id("org.x96.sys.buzz".getBytes()));
        ecoSys.bioIntegrate(
                """
                :bug Buzz
                    :gene code Hex;
                    :gene name Echo;
                    :gene secret Echo;
                    :gene brief? Buzz;
                ;
                """
                        .getBytes());
        assertEquals(1, ecoSys.biosphere.biome().organisms.size());
        assertPrintLn(
                """
                ☀️ [x96] [EcoSys] [SC]
                🪐 [biomes] [1]
                    🌍 [biome] [org.x96.sys.buzz]
                        🐞 [organisms] [1]
                        🦄 [folklore] (0) {0} [0]\
                """,
                () -> ecoSys.eco(""));

        assertEquals(
                """
                :logos org.x96.sys.buzz;

                :bug Buzz
                    :gene code Hex;
                    :gene name Echo;
                    :gene secret Echo;
                    :gene ?brief Buzz;
                ;
                """,
                ecoSys.emit(EcoTarget.SC));

        assertEquals(
                """
                @startuml
                package org.x96.sys.buzz {
                    struct Buzz {
                        + code: Hex
                        + name: Echo
                        + secret: Echo
                        + brief: ?Buzz
                    }
                }
                @enduml
                """,
                ecoSys.emit(EcoTarget.PUML));

        //        assertEquals(
        //                """
        //                        @startuml
        //                        package org.x96.sys.buzz {
        //                            struct Buzz {
        //                                + code: Hex
        //                                + name: Echo
        //                                + secret: Echo
        //                                + brief: ?Buzz
        //                            }
        //                        }
        //                        @enduml
        //                        """,
        //                ecoSys.emit(EcoTarget.RUST));
        assertEquals(
                """
                package org.x96.sys.buzz;

                public record Buzz(Integer code, String name, String secret, Optional<Buzz> brief) {
                }
                """,
                ecoSys.emit(EcoTarget.JAVA));

        assertEquals(
                // """
                // pub const Buzz = struct {
                // code: Hex,
                // name: Echo,
                // secret: Echo,
                // brief: ?*Buzz, // ponteiro opcional para outro Buzz
                //
                // pub fn init(code: Hex, name: Echo, secret: Echo) Buzz {
                // return Buzz{
                // .code = code,
                // .name = name,
                // .secret = secret,
                // .brief = null,
                // };
                // }
                // };
                // """,
                """
                // org/x96/sys/buzz/Buzz.zig

                pub const Buzz = struct {
                    code: Hex,
                    name: Echo,
                    secret: Echo,
                    brief: ?*Buzz,
                }\
                """,
                ecoSys.emit(EcoTarget.ZIG));
    }
}
