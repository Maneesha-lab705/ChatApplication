package lk.ijse.catmoon.Bo.custom;

import lk.ijse.catmoon.Dto.UserDto;

import java.sql.SQLException;

public interface UserBo {
    boolean save(UserDto userDto) throws SQLException;
}
