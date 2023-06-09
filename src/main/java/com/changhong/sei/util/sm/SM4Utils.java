package com.changhong.sei.util.sm;

import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 实现功能：SM4 无线局域网标准的分组数据算法。
 * 对称加密，密钥长度和分组长度均为128位。
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2022-03-17 19:21
 */
public class SM4Utils {

    private static final Pattern PATTERN = Pattern.compile("\\s*|\t|\r|\n");
    //	private String secretKey = "";
//    private String iv = "";
//    private boolean hexString = false;

    public String secretKey = "";
    private String iv = "";
    public boolean hexString = false;

    public SM4Utils() {
    }
//
//    public byte encryptData_ECB1(byte[] inputStream){
//        try
//        {
//            SM4_Context ctx = new SM4_Context();
//            ctx.isPadding = true;
//            ctx.mode = SM4.SM4_ENCRYPT;
//
//            byte[] keyBytes;
//            if (hexString)
//            {
//                keyBytes = Util.hexStringToBytes(secretKey);
//            }
//            else
//            {
//                keyBytes = secretKey.getBytes();
//            }
//
//            SM4 sm4 = new SM4();
//            sm4.sm4_setkey_enc(ctx, keyBytes);
//            String cipherText = new BASE64Encoder().encode(inputStream);
//            if (cipherText != null && cipherText.trim().length() > 0)
//            {
//                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
//                Matcher m = p.matcher(cipherText);
//                cipherText = m.replaceAll("");
//            }
//            return cipherText;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return (Byte) null;
//        }
//    }

    public String encryptData_ECB(String plainText) {
        try {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;

            byte[] keyBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
            } else {
                keyBytes = secretKey.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("GBK"));
            Base64.Encoder encoder = Base64.getEncoder();
            String cipherText = encoder.encodeToString(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0) {
                Matcher m = PATTERN.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptData_ECB(String cipherText) {
        try {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;

            byte[] keyBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
            } else {
                keyBytes = secretKey.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            Base64.Decoder decoder = Base64.getDecoder();

            byte[] decrypted = sm4.sm4_crypt_ecb(ctx, decoder.decode(cipherText));
            return new String(decrypted, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String encryptData_CBC(String plainText) {
        try {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            } else {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("GBK"));
            Base64.Encoder encoder = Base64.getEncoder();

            String cipherText = encoder.encodeToString(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0) {
                Matcher m = PATTERN.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptData_CBC(String cipherText) {
        try {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            } else {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            Base64.Decoder decoder = Base64.getDecoder();

            byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, decoder.decode(cipherText));
            return new String(decrypted, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        String plainText = "123456";

        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = "JeF8U9wHFOMfs2Y8";
        sm4.hexString = false;

        System.out.println("ECB模式加密");
        String cipherText = sm4.encryptData_ECB(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println("");

        plainText = sm4.decryptData_ECB(cipherText);
        System.out.println("明文: " + plainText);
        System.out.println("");

        System.out.println("CBC模式加密");
        sm4.iv = "UISwD9fW6cFh9SNS";
        cipherText = sm4.encryptData_CBC(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println("");

        plainText = sm4.decryptData_CBC(cipherText);
        System.out.println("明文: " + plainText);

        System.out.println("CBC模式解密");
        System.out.println("密文：4esGgDn/snKraRDe6uM0jQ==");
        String cipherText2 = "4esGgDn/snKraRDe6uM0jQ==";
        plainText = sm4.decryptData_CBC(cipherText2);
        System.out.println("明文: " + plainText);
    }
}
