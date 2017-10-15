package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;

import org.json.JSONException;

public interface IUserParser {

    IUser parse() throws JSONException;

}
