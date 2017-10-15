package com.github.rakickayakaterina.jsonparsing.parsers.models.json;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IFriend;

import org.json.JSONObject;

class FriendJson implements IFriend {

    private static final String ID = "id";
    private static final String NAME = "name";
    private final JSONObject mJSONObject;

    public FriendJson(final JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public int getId() {
        return mJSONObject.optInt(ID);
    }

    @Override
    public String getName() {
        return mJSONObject.optString(NAME);
    }
}
