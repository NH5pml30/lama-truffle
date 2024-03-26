package com.oracle.truffle.lama;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.lama.LamaLanguage;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LamaContext {
    private final LamaLanguage language;
    private final PrintStream out;
    private final Scanner inScanner;
    @CompilerDirectives.CompilationFinal private TruffleLanguage.Env env;

    public LamaContext(LamaLanguage language, TruffleLanguage.Env env) {
        this.env = env;
        this.out = new PrintStream(env.out());
        this.inScanner = new Scanner(env.in());
        this.language = language;
    }

    public InputStream getInput() {
        return env.in();
    }

    public Scanner getInScanner() {
        return inScanner;
    }

    public PrintStream getOutput() {
        return out;
    }

    public MaterializedFrame getGlobalScope() {
        return language.globalScope;
    }

    public void setGlobalScope(MaterializedFrame scope) {
        language.globalScope = scope;
    }

    private static final ContextReference<LamaContext> REFERENCE = ContextReference.create(LamaLanguage.class);

    public static LamaContext get(Node node) {
        return REFERENCE.get(node);
    }
}
