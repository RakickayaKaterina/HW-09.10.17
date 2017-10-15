package com.github.rakickayakaterina.jsonparsing.parsers.models.json;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;

import java.util.List;

public class UserJsonList implements IListUser {
    List<IUser> mUserList;

    public UserJsonList(List<IUser> pUserList) {
        mUserList = pUserList;
    }

    @Override
    public List<IUser> getListUser() {

        return mUserList;
    }
}
