package com.example.accountManage.Enum;

public enum UserState {
    ONLINE("online"),

    OFFLINE("offline"),

    MEETING("meeting");

    private final String value;

    UserState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
