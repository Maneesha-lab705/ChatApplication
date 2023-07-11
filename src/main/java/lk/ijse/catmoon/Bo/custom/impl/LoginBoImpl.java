package lk.ijse.catmoon.Bo.custom.impl;

import lk.ijse.catmoon.Bo.custom.LoginBo;
import lk.ijse.catmoon.Dao.UserDao;
import lk.ijse.catmoon.Dao.impl.UserDaoImpl;

import java.sql.SQLException;

public class LoginBoImpl implements LoginBo {
    UserDao userDao  =new UserDaoImpl();
    @Override
    public boolean serch(String name, String password) throws SQLException {
        return  userDao.serch(name,password);
    }
}
