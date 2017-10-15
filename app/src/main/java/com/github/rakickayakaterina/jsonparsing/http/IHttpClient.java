package com.github.rakickayakaterina.jsonparsing.http;

import java.io.InputStream;

public interface IHttpClient {
    InputStream request(String url);
}
