package org.x96.sys.sc.ecology.constants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.common.TRU;
import org.x96.sys.sc.ecology.EcoSys;
import org.x96.sys.sc.ecology.EcoTarget;
import org.x96.sys.sc.ir.Id;

public class EcoSysConstantsTest {

    @Test
    void happy() {
        EcoSys ecoSys = new EcoSys();
        String source = TRU.readInput("artifacts/constants/alone.sc");
        assertEquals("%VERSION = '0.1.2';", source);
        ecoSys.rise(new Id("".getBytes()));
        ecoSys.bioIntegrate(source.getBytes());
        String sourceGen = ecoSys.emit(EcoTarget.SC);
        assertEquals(source, sourceGen);
    }

    @Test
    void llvm() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String llvm = ecoSys.emit(EcoTarget.LLVM);
        assertEquals(TRU.r("llvm", "artifacts/constants/alone"), llvm);
    }

    @Test
    void zig() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String zig = ecoSys.emit(EcoTarget.ZIG);
        assertEquals(TRU.r("zig", "artifacts/constants/alone"), zig);
    }

    @Test
    void go() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String go = ecoSys.emit(EcoTarget.GO);
        assertEquals(TRU.r("go", "artifacts/constants/alone"), go);
    }

    @Test
    void swift() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String swift = ecoSys.emit(EcoTarget.SWIFT);
        assertEquals(TRU.r("swift", "artifacts/constants/alone"), swift);
    }

    @Test
    void puml() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String puml = ecoSys.emit(EcoTarget.PUML);
        assertEquals(TRU.r("puml", "artifacts/constants/alone"), puml);
    }

    @Test
    void ruby() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String ruby = ecoSys.emit(EcoTarget.RUBY);
        assertEquals(TRU.r("ruby", "artifacts/constants/alone"), ruby);
    }

    @Test
    void java() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String java = ecoSys.emit(EcoTarget.JAVA);
        assertEquals(TRU.r("java", "artifacts/constants/alone"), java);
    }

    @Test
    void ts() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String ts = ecoSys.emit(EcoTarget.TS);
        assertEquals(TRU.r("ts", "artifacts/constants/alone"), ts);
    }

    @Test
    void haskell() {
        EcoSys ecoSys = eco("artifacts/constants/alone.sc");
        String ts = ecoSys.emit(EcoTarget.HASKELL);
        assertEquals(TRU.r("haskell", "artifacts/constants/alone"), ts);
    }

    private EcoSys eco(String read) {
        EcoSys ecoSys = new EcoSys();
        String source = TRU.readInput(read);
        ecoSys.rise(new Id("".getBytes()));
        ecoSys.bioIntegrate(source.getBytes());
        return ecoSys;
    }
}
