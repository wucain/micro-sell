package com.wancient.springcloud.api.enums;

import lombok.Getter;

/**
 * 前端提示的消息
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/26
 * Time: 23:27
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),

    ORDER_CANCEL_SUCCESS(0, "订单取消成功"),

    ORDER_FINISH_SUCCESS(0, "订单完结成功"),

    PRODUCT_ON_SEAL_SUCCESS(0, "商品上架成功"),

    PRODUCT_OFF_SEAL_SUCCESS(0, "商品下架成功"),

    PRODUCT_SAVE_SUCCESS(0, "商品保存成功"),

    PRODUCT_CATEGORY_SAVE_SUCCESS(0, "商品类目保存成功"),

    DICTIONARY_SAVE_SUCCESS(0, "字典保存成功"),

    LOGOUT_SUCCESS(0, "登出成功"),


    PARAM_ERROR(1001, "参数错误"),

    PRODUCT_NOT_EXIST(10001, "商品不存在"),

    PRODUCT_STOCK_ERROR(10002, "库存不正确"),

    ORDER_NOT_EXIST(10003, "订单不存在"),

    ORDER_DETAIL_NOT_EXIST(10004, "订单详情不存在"),

    ORDER_STATUS_ERROR(10005, "订单状态不正确"),

    ORDER_UPDATE_FAIL(10006, "订单更新失败"),

    ORDER_DETAIL_EMPTY(10007, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(10008, "支付状态不正确"),

    CART_EMPTY(10009, "购物车为空"),

    ORDER_OWNER_ERROR(10010, "该订单不属于当前用户"),

    WECHAT_MP_ERROR(10020, "微信公众账号方面错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(10021, "微信支付异步通知金额校验不通过"),

    PRODUCT_STATUS_ERROR(10030, "商品状态不正确"),

    LOGIN_FAIL(10040, "登录失败, 登录信息不正确"),;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
