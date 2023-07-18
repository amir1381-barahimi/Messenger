package ir.brahimi.brahimichater.ui.contrller;

import ir.brahimi.brahimichater.service.UserService;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.ui.model.request.UserRequestModel;
import ir.brahimi.brahimichater.ui.model.response.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public UserResponseModel createUser(@RequestBody UserRequestModel userRequestModel){
        UserResponseModel returnValue;

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
        UserDto createdUser =userService.createUser(userDto);

        returnValue = modelMapper.map(createdUser,UserResponseModel.class);

        return returnValue;
    }
    @GetMapping("/{id}")
    public UserResponseModel getUser(@PathVariable String userName){
        ModelMapper modelMapper = new ModelMapper();
        UserResponseModel returnValue = new UserResponseModel();
        UserDto findUser = userService.getUserByUserName(userName);
        returnValue = modelMapper.map(findUser,UserResponseModel.class);
        return returnValue;
    }





}
