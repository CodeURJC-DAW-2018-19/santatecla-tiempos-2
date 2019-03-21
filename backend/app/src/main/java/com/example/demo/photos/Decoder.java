package com.example.demo.photos;

import java.util.Base64;

public class Decoder {
    public static String Encode(byte[] bytesArray)
    {
        byte[] encoded = Base64.getEncoder().encode(bytesArray);
        return new String(encoded);
    }

    public static byte[] Decode(String strBase64)
    {
        return Base64.getDecoder().decode(strBase64);
    }
}
