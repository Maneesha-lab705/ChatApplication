package lk.ijse.catmoon.Bo.custom;

import java.sql.SQLException;

public interface LoginBo {
    boolean serch(String name, String password) throws SQLException;
}
