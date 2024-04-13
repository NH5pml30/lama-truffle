package com.oracle.truffle.lama.parser;

// Uniquely reference a value by its parent scope and its name
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

    public <U> Capture<U> reset(U value) {
        return new Capture<>(value, source, name);
    }
}
