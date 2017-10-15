package com.github.rakickayakaterina.jsonparsing.parsers;

public final class ParserFactory {

    public static final int GSON = 0;
    public static final int JSON = 1;

    public static IUserParser createUserParser(final int pTypeParser, final String mSource) {
        switch (pTypeParser) {
            case JSON:
                return new UserJsonParser(mSource);
            case GSON:
                return new UserGsonParser(mSource);
        }
        throw new IllegalArgumentException();
    }

    public static IListUserParser createListUserParser(final int pTypeParser, final String mSource) {
        switch (pTypeParser) {
            case JSON:
                return new ListUserJsonParser(mSource);
            case GSON:
                return new ListUserGsonParser(mSource);
        }
        throw new IllegalArgumentException();
    }

}
