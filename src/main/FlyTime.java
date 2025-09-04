import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.visitor.Visitor;
import org.x96.sys.parser.Tape;
import org.x96.sys.sc.ast.synthetic.Sc;
import org.x96.sys.sc.ast2ir.converters.ScToTree;
import org.x96.sys.sc.emit.java.EmitJavaTree;
import org.x96.sys.sc.emit.self.EmitTree;
import org.x96.sys.sc.ir.synthetic.Tree;
import org.x96.sys.sc.parser.ParserSC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlyTime {
    public static void main(String[] args) throws Exception {
        String command = args[0];
        switch (command) {
            case "sc":
                interprets(args);
                break;
            case "parse":
                parse(args);
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

    private static void parse(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("usage: parser <artifact.sc>");
            return;
        }
        String scPath = args[1];
        System.out.println("parsing: " + scPath);
        byte[] payload = Files.readAllBytes(Path.of(scPath));
        Lexer lexer = new Lexer(org.x96.sys.sc.lexer.visitors.synthetic.Sc.class);
        Token[] tokens = lexer.lexWrapped(payload);
        Sc sc = new ParserSC(new Tape(tokens)).parse();
        sc.prettyPrint("");
        Tree tree = new ScToTree().convert(sc);
        tree.prettyPrint("");
        System.out.println("################");
        System.out.println("##### self #####");
        System.out.println("################");
        System.out.println(new EmitTree(tree).toSC());
//        System.out.println("################");
//        System.out.println("##### java #####");
//        System.out.println("################");
//        System.out.println(new EmitJavaTree(tree).toJava());
//        System.out.println("################");
//        System.out.println("##### LLVM #####");
//        System.out.println("################");
//        System.out.println(new EmitJavaTree(tree).toJava());
//        System.out.println("################");
//        System.out.println("####### C ######");
//        System.out.println("################");
//        System.out.println(new EmitJavaTree(tree).toJava());
//        System.out.println("################");
//        System.out.println("##### ruby #####");
//        System.out.println("################");
//        System.out.println(new EmitJavaTree(tree).toJava());
//        System.out.println("################");
//        System.out.println("##### rust #####");
//        System.out.println("################");
//        System.out.println(new EmitJavaTree(tree).toJava());
    }
}
