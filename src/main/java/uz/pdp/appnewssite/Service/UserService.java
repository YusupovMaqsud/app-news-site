package uz.pdp.appnewssite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.entity.Lavozim;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.exceptions.ResourceNotFoundException;
import uz.pdp.appnewssite.payload.ApiResponse;
import uz.pdp.appnewssite.payload.UserDto;
import uz.pdp.appnewssite.repository.LavozimRepository;
import uz.pdp.appnewssite.repository.UserRepository;
import uz.pdp.appnewssite.utils.AppConstants;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LavozimRepository lavozimRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }




    public ApiResponse addUser(UserDto userDto) {
        if (!userRepository.existsByUsername(userDto.getUsername())) {
            return new ApiResponse( " Bunday username bor", false);
        }

        User user = new User(
                userDto.getFullName(),
                userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()),
                lavozimRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResourceNotFoundException("lavozim", "name", AppConstants.USER)),
                true
        );
        userRepository.save(user);

        return new ApiResponse("user saqlandi", true);
    }




    public ApiResponse editUser(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ApiResponse("Bunday user mavjud emas", false);
        }
        User user = optionalUser.get();
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Lavozim lavozim = lavozimRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResourceNotFoundException("lavozim", "name", AppConstants.USER));
        user.setLavozim(lavozim);
        userRepository.save(user);

        return new ApiResponse("User tahrirlandi", true);
    }




    public ApiResponse deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ApiResponse("User deleted", true);
    }
}
