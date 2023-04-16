package com.example.accountManage.util;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class UUIDUtils {

    public static String generateUuid(String input) {
        //先获取当前的时间戳
        String timestamp =Long.toString(System.currentTimeMillis());
        //再将userName和时间戳拼接
        String userNameAndTimestamp = input + timestamp;
        //利用拼接后的字符串生成uuid
        return UUID.nameUUIDFromBytes(userNameAndTimestamp.getBytes(StandardCharsets.UTF_8)).toString();
    }
}
