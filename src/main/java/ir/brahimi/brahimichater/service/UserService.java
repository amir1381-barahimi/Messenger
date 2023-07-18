package ir.brahimi.brahimichater.service;

import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.ui.model.request.UserRequestModel;
import ir.brahimi.brahimichater.ui.model.response.UserResponseModel;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public UserDto getUserByUserName(String userName);
}
