package com.github.rakickayakaterina.jsonparsing.parsers.models.gson;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;

import java.util.List;

public class UserGsonList implements IListUser {

    private List<IUser> mUserList;

    public UserGsonList(final List<IUser> pUserList) {
        mUserList = pUserList;
    }

    @Override
    public List<IUser> getListUser() {

        return mUserList;
    }
}
