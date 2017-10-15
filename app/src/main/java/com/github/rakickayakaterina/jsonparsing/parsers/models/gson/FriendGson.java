package com.github.rakickayakaterina.jsonparsing.parsers.models.gson;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IFriend;
import com.google.gson.annotations.SerializedName;

class FriendGson implements IFriend {

    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;

    FriendGson() {
    }

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }
}
