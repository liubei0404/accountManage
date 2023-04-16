package com.example.accountManage.Enum;

public enum Message {

    /**
     * 登录相关
     */
    LOGIN_NULL("输入的账号不存在，请重新核对后输入"),

    LOGIN_SUCCESS("登录成功!"),

    LOGIN_ERROR("输入密码错误，请重新输入"),

    /**
     * 注册相关
     */
    REGISTER_SUCCESS("注册成功"),

    REGISTER_ERROR("注册失败"),

    /**
     * 操作相关
     */
    SUCCESS("成功"),

    FAIL("失败"),

    /**
     * 用户信息相关
     */
    USERID_NULL("用户账号为空"),

    USERNAME_NULL("用户名为空"),

    USERID_AND_USERNAME_NULL("用户账号或者用户名为空");



    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
