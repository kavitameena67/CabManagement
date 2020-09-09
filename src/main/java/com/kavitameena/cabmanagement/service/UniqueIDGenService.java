package com.kavitameena.cabmanagement.service;

import java.sql.Timestamp;

public class UniqueIDGenService {

    public static long getNextId() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return ts.getTime();
    }
}
