package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;

import org.json.JSONException;

public interface IListUserParser {
    IListUser parse() throws JSONException;
}
