package org.mossmc.mosscg.MoBoxPoint.Mysql;

import java.sql.Connection;
import java.sql.ResultSet;

public class MysqlTable {
    public static void checkTable() {
        try {
            Connection connection = MysqlConnection.getConnection();
            ResultSet set = connection.getMetaData().getTables(null,null,"moboxpoint",null);
            if (!set.next()) {
                initTable(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public static void initTable(Connection connection) throws Exception {
        connection.prepareStatement("CREATE TABLE `moboxpoint`  (\n" +
                "  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,\n" +
                "  `data` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,\n" +
                "  PRIMARY KEY (`name`) USING BTREE\n" +
                ") ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC").executeUpdate();
    }
}
