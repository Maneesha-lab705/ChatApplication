package lk.ijse.catmoon.Bo.custom.impl;

import lk.ijse.catmoon.Bo.custom.UserBo;
import lk.ijse.catmoon.Dao.UserDao;
import lk.ijse.catmoon.Dao.impl.UserDaoImpl;
import lk.ijse.catmoon.Dto.UserDto;
import lk.ijse.catmoon.Entity.User;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    UserDao userDao =new UserDaoImpl();
    @Override
    public boolean save(UserDto userDto) throws SQLException {
        return userDao.save(new User(userDto.getName(),userDto.getMail(),userDto.getPassword()));

    }

}
