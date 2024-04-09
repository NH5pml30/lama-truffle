package com.oracle.truffle.lama.parser;

record Capture<T>(T value, LexicalScope source, String name) {
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Capture<?> o)) {
            return false;
        }
        return source == o.source && name.equals(o.name);
    }
}
