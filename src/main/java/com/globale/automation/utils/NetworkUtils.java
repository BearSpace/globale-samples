package com.globale.automation.utils;

import javaslang.control.Try;

import java.net.InetAddress;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public final class NetworkUtils {

    public static String getIp() {
        return Try.of(() -> InetAddress.getLocalHost().getHostAddress())
                .orElseThrow((ex) -> new IllegalArgumentException("Failed to get localhost ip address.", ex));
    }

    private NetworkUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }
}
