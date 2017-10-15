package com.github.rakickayakaterina.jsonparsing.parsers.models.gson;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IFriend;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserGson implements IUser {

    private static final String ID = "_id";
    private static final String INDEX = "index";
    private static final String GUID = "guid";
    private static final String IS_ACTIVE = "isActive";
    private static final String BALANCE = "balance";
    private static final String PICTURE = "picture";
    private static final String AGE = "age";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String REGISTERED = "registered";
    private static final String TAGS = "tags";
    private static final String FRIENDS = "friends";

    @SerializedName(ID)
    private String mId;
    @SerializedName(INDEX)
    private int mIndex;
    @SerializedName(GUID)
    private String mGuid;
    @SerializedName(IS_ACTIVE)
    private boolean mIsActive;
    @SerializedName(BALANCE)
    private String mBalance;
    @SerializedName(PICTURE)
    private String mPicture;
    @SerializedName(AGE)
    private int mAge;
    @SerializedName(NAME)
    private String mName;
    @SerializedName(GENDER)
    private String mGender;
    @SerializedName(REGISTERED)
    private long mRegistered;
    @SerializedName(TAGS)
    private String[] mTags;
    @SerializedName(FRIENDS)
    private FriendGson[] mFriends;

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public int getIndex() {
        return mIndex;
    }

    @Override
    public String getGuid() {
        return mGuid;
    }

    @Override
    public boolean getIsActive() {
        return mIsActive;
    }

    @Override
    public String getBalance() {
        return mBalance;
    }

    @Override
    public String getPicture() {
        return mPicture;
    }

    @Override
    public int getAge() {
        return mAge;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getGender() {
        return mGender;
    }

    @Override
    public Date getRegistered() {

        return new Date(mRegistered);
    }

    @Override
    public List<String> getTags() {
        return Arrays.asList(mTags);
    }

    @Override
    public List<IFriend> getFriends() {
        List<IFriend> friendList = new LinkedList<>();
        for (int i = 0; i < mFriends.length; i++) {
            friendList.add(mFriends[i]);
        }
        return friendList;
    }
}
