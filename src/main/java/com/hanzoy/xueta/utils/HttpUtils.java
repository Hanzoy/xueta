package com.hanzoy.xueta.utils;

import com.hanzoy.xueta.domain.User;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class HttpUtils {
    public static final String BASIC = "Basic OTVhMzRhZjhhZjc1MWZlM2FmNzRlYzc0OmU0ZTk2ZjZmZTU2NzY3Zjc0N2E0ZGIwYQ==";

    public static boolean changePassword(User user){
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        String param = "{\"new_password\":\""+user.getPassword()+"\"}";
        String URL = "https://api.im.jpush.cn/v1/users/"+user.getUsername()+"/password";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), param);
        Request request = new Request.Builder()
                .url(URL)
                .put(requestBody)
                .addHeader("Authorization", BASIC)
                .build();
        Call call = client.newCall(request);
        String responseBody = "";
        try {
            responseBody = Objects.requireNonNull(call.execute().body()).string();
        } catch (IOException e) {
            return false;
        }
        return responseBody.equals("");
    }
}
