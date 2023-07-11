package lk.ijse.catmoon.Dao;

import java.sql.SQLException;

public interface CrudDao <T,Id>{
    boolean save(T user) throws SQLException;

    boolean serch(String name, String password) throws SQLException;
}
