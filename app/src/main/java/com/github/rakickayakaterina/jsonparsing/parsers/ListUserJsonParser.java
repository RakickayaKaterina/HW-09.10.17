package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.json.UserJson;
import com.github.rakickayakaterina.jsonparsing.parsers.models.json.UserJsonList;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.LinkedList;
import java.util.List;

public class ListUserJsonParser implements IListUserParser {

    String mSource;

    public ListUserJsonParser(String pSource) {
        mSource = pSource;
    }

    @Override
    public IListUser parse() throws JSONException {
        JSONArray jsonArray = new JSONArray(mSource);
        List<IUser> userList = new LinkedList<>();
        for(int i=0;i<jsonArray.length();i++){
            userList.add(new UserJson(jsonArray.optJSONObject(i)));
        }
        return new UserJsonList(userList);
    }
}
