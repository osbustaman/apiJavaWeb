package com.api.apis.Connection;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public String generaToken(){
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String key = "";
        for (int x = 0; x < 150; x++) {
                int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, (banco.length() - 1) + 1);
                char caracterAleatorio = banco.charAt(indiceAleatorio);
                key += caracterAleatorio;
        }
        return key;
    }
}
