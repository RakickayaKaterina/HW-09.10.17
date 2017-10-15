package com.github.rakickayakaterina.jsonparsing;

import com.github.rakickayakaterina.jsonparsing.http.IHttpClient;
import com.github.rakickayakaterina.jsonparsing.mocks.Mocks;
import com.github.rakickayakaterina.jsonparsing.parsers.IListUserParser;
import com.github.rakickayakaterina.jsonparsing.parsers.IUserParser;
import com.github.rakickayakaterina.jsonparsing.parsers.ParserFactory;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.utils.IOUtils;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = 21
)
public class ParserTest {

    public static final String USER_JSON = "user.json";
    public static final String USERS_LIST_JSON = "usersList.json";
    public static final String HTTP_LOCALHOST_USER = "http://localhost/user";
    public static final String HTTP_LOCALHOST_LIST_USER = "http://localhost/listUser";

    InputStream httpUserStream;
    InputStream httpListUserStream;
    IHttpClient mHttpClient = mock(IHttpClient.class);

    @Before
    public void init() {
        httpUserStream = Mocks.stream(USER_JSON);
        httpListUserStream = Mocks.stream(USERS_LIST_JSON);
        when(mHttpClient.request(HTTP_LOCALHOST_USER)).thenReturn(httpUserStream);
        when(mHttpClient.request(HTTP_LOCALHOST_LIST_USER)).thenReturn(httpListUserStream);

    }

    @Test
    public void userJsonTest() throws IOException, JSONException {

        IUserParser userJsonParser = ParserFactory.createUserParser(ParserFactory.JSON, IOUtils.toString(mHttpClient.request(HTTP_LOCALHOST_USER)));
        IUser user = userJsonParser.parse();
        assertEquals("Jacobson Mclaughlin", user.getName());
        assertEquals(26, user.getAge());
        assertEquals("Alissa Goodman", user.getFriends().get(0).getName());
    }

    @Test
    public void userGsonTest() throws IOException, JSONException {

        IUserParser userGsonParser = ParserFactory.createUserParser(ParserFactory.GSON, IOUtils.toString(mHttpClient.request(HTTP_LOCALHOST_USER)));
        IUser user = userGsonParser.parse();
        assertEquals("Jacobson Mclaughlin", user.getName());
        assertEquals(26, user.getAge());
        assertEquals("Alissa Goodman", user.getFriends().get(0).getName());
    }

    @Test
    public void listUserJsonParser() throws IOException, JSONException {
        IListUserParser listUserJsonParser = ParserFactory.createListUserParser(ParserFactory.JSON, IOUtils.toString(mHttpClient.request(HTTP_LOCALHOST_LIST_USER)));
        IListUser listUser = listUserJsonParser.parse();
        assertEquals(5, listUser.getListUser().size());

    }

    @Test
    public void listUserGsonParser() throws IOException, JSONException {
        IListUserParser listUserGsonParser = ParserFactory.createListUserParser(ParserFactory.GSON, IOUtils.toString(mHttpClient.request(HTTP_LOCALHOST_LIST_USER)));
        IListUser listUser = listUserGsonParser.parse();
        assertEquals(5, listUser.getListUser().size());

    }

    @After
    public void close() {

        try {
            httpUserStream.close();
            httpListUserStream.close();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }
}