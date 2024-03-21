package com.oracle.truffle.lama;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;

import static com.oracle.truffle.lama.parser.LamaParser.parseLama;

@TruffleLanguage.Registration(id = LamaLanguage.ID, name = "Lama", defaultMimeType = LamaLanguage.MIME_TYPE,
    characterMimeTypes = LamaLanguage.MIME_TYPE)
public class LamaLanguage extends TruffleLanguage<Void> {
    public static final String ID = "lama";
    public static final String MIME_TYPE = "application/x-lama";

    @Override
    protected Void createContext(Env env) {
        return null;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) {
        return parseLama(this, request.getSource());
    }
}