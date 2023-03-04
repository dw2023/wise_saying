package org.example;

import java.util.HashMap;
import java.util.Map;

// Rq = Request
public class Rq {
    private String actionCode;
    private Map<String, String> params;
    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2);
        // ? 앞에는 "\\"를 써줘야 함
        // limit: 2 = 최대 두 개까지 나눈다
        actionCode = commandBits[0];

        params= new HashMap<>(); // Map에 'id=1&authorName=홍길동' 저장
        String[] paramsBits = commandBits[1].split("&"); // 'id=1&authorName=홍길동'을 "&"로 나누기

        for ( String paramStr : paramsBits ) {
            String[] paramStrBits = paramStr.split("=", 2); // "id=1" 을 "="기준으로 나누기
            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }
}