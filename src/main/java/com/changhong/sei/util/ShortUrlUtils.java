package com.changhong.sei.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * 实现功能：短连接
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-01-08 00:49
 */
public class ShortUrlUtils {
    //十六进制下数字到字符的映射数组
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    /**
     * MD5生成 ，其实这个算法主要是把长字符串变小
     * 这个算法是不可逆的，所以别想着去直接反转短地址
     */
    public static String[] getShortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "sei_";
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"

        };

        String[] resUrl = new String[4];
        try {
            // 对传入网址进行 MD5 加密 创建具有指定算法名称的信息摘要
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
            byte[] results = md5.digest((key + url).getBytes());
            //将得到的字节数组变成字符串返回
            String hex = byteArrayToHexString(results);

            for (int i = 0; i < 4; i++) {
                // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
                String sTempSubString = hex.substring(i * 8, i * 8 + 8);

                // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用
                // long ，则会越界
                long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
                StringBuilder outChars = new StringBuilder();
                for (int j = 0; j < 6; j++) {
                    // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                    long index = 0x0000003D & lHexLong;
                    // 把取得的字符相加
                    outChars.append(chars[(int) index]);
                    // 每次循环按位右移 5 位
                    lHexLong = lHexLong >> 5;
                }
                // 把字符串存入对应索引的输出数组
                resUrl[i] = outChars.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resUrl;
    }

    /**
     * 轮换字节数组为十六进制字符串
     *
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String getShortUrlStr(String url) {
        String[] aResult = getShortUrl(url);
        return StringUtils.join(aResult);
    }

    public static void main(String[] args) {
        String sLongUrl = "http://39605929.qzone.qq.com"; // 长链接
        String[] aResult = getShortUrl(sLongUrl);
        // 打印出结果
        for (int i = 0; i < aResult.length; i++) {
            System.out.println("[" + i + "]" + aResult[i]);
        }
        System.out.println(StringUtils.join(aResult));
    }
}
