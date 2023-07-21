package ir.brahimi.brahimichater.service;

import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.ui.model.request.UserLoginRequestModel;

import javax.naming.AuthenticationException;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public UserDto getUserByUserName(String userName);
    public boolean register(UserLoginRequestModel userLoginRequestModel) throws AuthenticationException;
}
