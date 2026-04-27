
package com.storeqa.utils;

import java.util.UUID;

public class EmailUtil {

    public static String generateUniqueEmail() {
        return "test" + UUID.randomUUID().toString().substring(0,5) + "@gmail.com";
    }
}