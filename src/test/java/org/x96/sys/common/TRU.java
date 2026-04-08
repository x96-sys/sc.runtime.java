package org.x96.sys.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * TestResourceUtils
 *
 * <p>Utility class for reading test resources following Maven/Gradle best practices. Separates test
 * inputs from expected outputs for better maintainability.
 */
public class TRU {

    private static final String RESOURCES_BASE = "src/test/resources";
    private static final String INPUT_DIR = RESOURCES_BASE + "/input";
    private static final String EXPECTED_DIR = RESOURCES_BASE + "/expected";

    /** Reads a test input file from src/test/resources/input/ */
    public static String readInput(String filename) {
        return readFile(INPUT_DIR + "/" + filename);
    }

    /**
     * Reads an expected output file for a specific target
     *
     * @param target Target language (sc, java, zig, ts, puml, llvm)
     * @param filename Filename without extension
     * @return Expected content
     */
    public static String r(String target, String filename) {
        String extension = getExtension(target);
        return readFile(EXPECTED_DIR + "/" + target + "/" + filename + "." + extension);
    }

    public static byte[] rb(String target, String filename) {
        return r(target, filename).getBytes();
    }

    /** Reads input bytes for bioIntegrate */
    public static byte[] readInputBytes(String filename) {
        return readInput(filename).getBytes();
    }

    private static String readFile(String relativePath) {
        try {
            Path path = Paths.get(relativePath);
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test resource: " + relativePath, e);
        }
    }

    private static String getExtension(String target) {
        return switch (target.toLowerCase()) {
            case "sc" -> "sc";
            case "java" -> "java";
            case "zig" -> "zig";
            case "go" -> "go";
            case "ts", "typescript" -> "ts";
            case "puml", "plantuml" -> "puml";
            case "llvm" -> "ll";
            case "ruby" -> "rb";
            case "haskell" -> "hs";
            case "swift" -> "swift";
            default -> target;
        };
    }
}
