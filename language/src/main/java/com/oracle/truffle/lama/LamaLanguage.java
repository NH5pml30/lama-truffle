package com.oracle.truffle.lama;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.MaterializedFrame;

import static com.oracle.truffle.lama.parser.LamaParser.parseLama;

@TruffleLanguage.Registration(id = LamaLanguage.ID, name = "Lama", defaultMimeType = LamaLanguage.MIME_TYPE,
    characterMimeTypes = LamaLanguage.MIME_TYPE)
public class LamaLanguage extends TruffleLanguage<LamaContext> {
    public static final String ID = "lama";
    public static final String MIME_TYPE = "application/x-lama";

    @Override
    protected LamaContext createContext(Env env) {
        return new LamaContext(this, env);
    }

    @Override
    protected CallTarget parse(ParsingRequest request) {
        var res = parseLama(this, request.getSource());
        return res;
    }
}
