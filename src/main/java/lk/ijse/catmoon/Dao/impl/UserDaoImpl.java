package lk.ijse.catmoon.Dao.impl;

import lk.ijse.catmoon.Dao.UserDao;
import lk.ijse.catmoon.Entity.User;
import lk.ijse.catmoon.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User user) throws SQLException {
        String sql ="INSERT INTO user(Name,Email,Password)VALUES(?,?,?)";
        return CrudUtil.execute(sql,user.getName(),user.getMail(),user.getPassword());
    }

    @Override
    public boolean serch(String name, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE Name = ? && Password= ?";
        ResultSet resultSet = CrudUtil.execute(sql,name,password);

        if (resultSet.next()){
            return true;
        }
        return false;
    }

}
