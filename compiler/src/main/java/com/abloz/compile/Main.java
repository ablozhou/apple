package com.abloz.compile;
import com.abloz.antlr.AppleLexer;
import com.abloz.antlr.AppleParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
/**
 *
 *@author Andy Zhou <ablozhou@gmail.com>
 *@date 2019.08.15
 */
public class Main {

    public static void main(String[] args) {

        if(args.length < 1) {
            System.out.println("run:\n java -jar compiler-1.0-SNAPSHOT-jar-with-dependencies.jar xxx.ap");
            return;
        }
        String inputFile = args[0];
        CharStream input =null;

        try {
            input = CharStreams.fromFileName(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String appleExpr = "3+2*5";
//        CharStream input = CharStreams.fromString(appleExpr);
        AppleLexer lexer=new AppleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AppleParser parser = new AppleParser(tokens);
        ParseTree tree = parser.prog(); // parse
        AppleVisitorImpl vt=new AppleVisitorImpl();
        Integer i = vt.visit(tree);
        System.out.println("out:"+i);

    
    }
}