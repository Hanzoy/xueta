package com.hanzoy.xueta.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanzoy.xueta.dto.param.PostTimeParam.Groups;
import com.hanzoy.xueta.domain.User;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class HttpUtils {
    public static final String BASIC = "Basic OTVhMzRhZjhhZjc1MWZlM2FmNzRlYzc0OmU0ZTk2ZjZmZTU2NzY3Zjc0N2E0ZGIwYQ==";
    public static final OkHttpClient client = new OkHttpClient().newBuilder().build();

    public static boolean changePassword(User user){
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

    public static List<Groups> getGroups(String username){
        String URL = "https://api.im.jpush.cn/v1/users/"+username+"/groups";
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("Authorization", BASIC)
                .build();
        Call call = client.newCall(request);
        String responseBody = "";
        List<Groups> res = new ArrayList<>();
        try {
            responseBody = Objects.requireNonNull(call.execute().body()).string();

            ObjectMapper objectMapper = new ObjectMapper();

            List list = objectMapper.readValue(responseBody, List.class);
            if(list != null && !list.isEmpty()){
                for (Object o : list) {
                    Groups groups = new Groups();
                    groups.setId((((HashMap<String, Integer>)o).get("gid")));
                    res.add(groups);
                }
            }else {
                return new ArrayList<>();
            }
            return res;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static int getNumber(int GroupId){
        String URL = "https://api.im.jpush.cn/v1/groups/"+GroupId+"/members";
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("Authorization", BASIC)
                .build();
        Call call = client.newCall(request);
        String responseBody = "";
        try {
            responseBody = Objects.requireNonNull(call.execute().body()).string();
            ObjectMapper objectMapper = new ObjectMapper();

            List list = objectMapper.readValue(responseBody, List.class);
            return list.size();
        } catch (IOException e) {
            return -1;
        }
    }

    public static void sendVerificationCode(String phone, String code){
        String URL = "http://api.smsbao.com/sms?u=hanzoy&p=35293F284C4BB4C979332C80EE2B0DC8&m="+phone+"&c=%e3%80%90%e5%ad%a6%e4%bb%96%e3%80%91%e6%82%a8%e7%9a%84%e9%aa%8c%e8%af%81%e7%a0%81%e4%b8%ba"+code+"%ef%bc%8c%e8%af%b7%e5%9c%a85%e5%88%86%e9%92%9f%e5%86%85%e5%ae%8c%e6%88%90%e6%93%8d%e4%bd%9c%e3%80%82%e9%aa%8c%e8%af%81%e7%a0%81%e8%af%b7%e5%8b%bf%e6%b3%84%e9%9c%b2%ef%bc%8c%e5%a6%82%e9%9d%9e%e6%9c%ac%e4%ba%ba%e6%93%8d%e4%bd%9c%ef%bc%8c%e8%af%b7%e5%bf%bd%e7%95%a5%e3%80%82";
        Request request = new Request.Builder()
                .url(URL)
                .build();
        try {
            Objects.requireNonNull(client.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        System.out.println(getGroups("321321"));
        System.out.println(getNumber(47145054));
    }
}
