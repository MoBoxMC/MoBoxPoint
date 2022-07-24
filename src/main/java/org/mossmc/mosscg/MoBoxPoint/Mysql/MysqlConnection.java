package org.mossmc.mosscg.MoBoxPoint.Mysql;

import static org.mossmc.mosscg.MoBoxPoint.Main.getConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
    public static Connection getConnection() throws Exception{
        String address = getConfig.getString("sqlAddress");
        String port = getConfig.getString("sqlPort");
        String database = getConfig.getString("sqlDatabase");
        String username = getConfig.getString("sqlUsername");
        String password = getConfig.getString("sqlPassword");
        String sqlAddress = "jdbc:mysql://"+address+":"+port+"/"+database+"?autoReconnect=true&characterEncoding=utf8&useSSL=false";
        return DriverManager.getConnection(sqlAddress,username,password);
    }
}
