import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.visitor.Visitor;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.Anatomy;
import org.x96.sys.sc.ast.Behavior;
import org.x96.sys.sc.ast.Genome;
import org.x96.sys.sc.ast.Sc;
import org.x96.sys.sc.ast2ir.converters.ScToTree;
import org.x96.sys.sc.ecology.EcoSys;
import org.x96.sys.sc.ecology.EcoTarget;
import org.x96.sys.sc.ir.Tree;
import org.x96.sys.sc.parser.ParserSC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlyTime {

    private static final EcoSys ecoSys = new EcoSys();

    public static void main(String[] args) throws Exception {
        String command = args[0];
        switch (command) {
            case "sc":
                interprets(args);
                break;
            case "parse":
                parse(args);
                break;
            case "repl":
                repl(args);
                break;
            case "tokenize":
                tokenize(args);
                break;
            case "pollinate":
                System.out.println("pollinate");
                break;
            default:
                System.out.printf("unknown command [%s]%n", command);
        }
    }

    private static void tokenize(String[] args) throws Exception {
        System.out.println("SC v0.1.2");
        String f = args[1];
        String k = args[2];
        System.out.println("abrindo: " + f);
        System.out.println("entry: " + k);
        Class<? extends Visitor> cls = loadVisitor(k);
        Lexer lexer = new Lexer(cls);
        Token[] tokens = lexer.lexWrapped(Files.readAllBytes(Path.of(f)));
        for (Token t : tokens) {
            System.out.println(t);
        }
    }

    private static Class<? extends Visitor> loadVisitor(String className) throws Exception {
        return Class.forName(className).asSubclass(Visitor.class);
    }

    private static void interprets(String[] args) {
        System.out.println("SC v0.1.2");
    }

    private static Token[] scTokenize(String f) throws IOException {
        return new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Sc.class)
                .lexWrapped(Files.readAllBytes(Path.of(f)));
    }

    private static Tree parseTree(String f) throws IOException {
        Sc sc = new ParserSC(new Tape(scTokenize(f))).parse();
        sc.prettyPrint("");
        return new ScToTree().convert(sc);
    }

    private static void repl(String[] args) throws IOException {
        // eh preciso distinguir o logos
        // ele se reflete no path do arquivo
        // caso o logos seja vazio, o arquivo fica na raiz dos artefatos
        //
        // m sc ARGS="parse docs/artifacts/repl/sc0.sc"
        // m sc ARGS="repl docs/artifacts/org/x96/sys/echo.sc"

        // READ
        // parse, ast
        if (args.length != 2) {
            System.out.println("usage: parser <artifact.sc>");
            throw new RuntimeException("invalid arguments");
        }
        String scPath = args[1];
        System.out.println("parsing: " + scPath);
        byte[] payload = Files.readAllBytes(Path.of(scPath));
        ecoSys.bioIntegrate(payload);
        System.out.println(ecoSys.emit(EcoTarget.SC));
        System.out.println(ecoSys.emit(EcoTarget.JAVA));

        // Sc ast = prs(args);
        // for (Genome g : ast.nymph().pupa().genome()) {
        // repl_visit(g);
        // }

        // EVAL
        // modifica a ir

        // PRINT
        // imprime a mudança

        // LOOP
        // continua
    }

    private static void repl_visit(Genome g) {
        // TODO Auto-generated method stub
        switch (g) {
            case Anatomy a:
                a.prettyPrint("");
                throw new RuntimeException("anatomy not supported yet");
            // break;
            case Behavior b:
                b.prettyPrint("");
                throw new RuntimeException("behavior not supported yet");
                // break;
        }
    }

    private static void parse(String[] args) throws IOException {
        Tree tree = new ScToTree().convert(prs(args));
        tree.prettyPrint("");
        // System.out.println("################");
        // System.out.println("##### self #####");
        // System.out.println("################");
        // System.out.println(new EmitTree(tree).toSC());
        // System.out.println("################");
        // System.out.println("##### java #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("##### LLVM #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("####### C ######");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("##### ruby #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("##### rust #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
    }

    private static Sc prs(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("usage: parser <artifact.sc>");
            return null;
        }
        String scPath = args[1];
        System.out.println("parsing: " + scPath);
        byte[] payload = Files.readAllBytes(Path.of(scPath));
        Lexer lexer = new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Sc.class);
        Token[] tokens = lexer.lexWrapped(payload);
        // Sc sc = new ParserSC(new Tape(tokens)).parse();
        return new ParserSC(new Tape(tokens)).parse();
        // sc.prettyPrint("");
        // return new ScToTree().convert(sc);
        // tree.prettyPrint("");
        // System.out.println("################");
        // System.out.println("##### self #####");
        // System.out.println("################");
        // System.out.println(new EmitTree(tree).toSC());
        // System.out.println("################");
        // System.out.println("##### java #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("##### LLVM #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("####### C ######");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("##### ruby #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
        // System.out.println("################");
        // System.out.println("##### rust #####");
        // System.out.println("################");
        // System.out.println(new EmitJavaTree(tree).toJava());
    }
}
