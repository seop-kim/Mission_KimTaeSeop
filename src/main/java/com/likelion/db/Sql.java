package com.likelion.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Sql {

    private final Connection connection;
    private final List<Object> parameters;

    public Sql(Connection connection) {
        this.connection = connection;
        this.parameters = new ArrayList<>();
    }

}