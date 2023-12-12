package com.gthsoftware.casino.utils;


import java.util.Map;

public class Constant {

    private Constant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESULT_OK = "OK";
    public static final String RESULT_KO = "KO";
    public static final String GERNERIC_RESPOONSE_CODE = "KO";

    public static final String USER_RESPONSE_CODE_PREFIX = "USER-";

    public static Map<String, String> getUserResponseHashMap() {
        return Map.of(
                USER_RESPONSE_CODE_PREFIX + "1", "USER not found",
                USER_RESPONSE_CODE_PREFIX + "2", "USER already exists",
                USER_RESPONSE_CODE_PREFIX + "3", "USER not created",
                USER_RESPONSE_CODE_PREFIX + "4", "USER not updated",
                USER_RESPONSE_CODE_PREFIX + "5", "USER not deleted",
                USER_RESPONSE_CODE_PREFIX + "6", "USER found",
                USER_RESPONSE_CODE_PREFIX + "7", "USER created",
                USER_RESPONSE_CODE_PREFIX + "8", "USER updated",
                USER_RESPONSE_CODE_PREFIX + "9", "USER deleted",
                USER_RESPONSE_CODE_PREFIX + "10", "USER list found"
        );
    }
}
