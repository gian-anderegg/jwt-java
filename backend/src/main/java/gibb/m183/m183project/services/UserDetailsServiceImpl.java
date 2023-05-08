package gibb.m183.m183project.services;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import gibb.m183.m183project.models.Role;
import gibb.m183.m183project.payload.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gibb.m183.m183project.models.User;
import gibb.m183.m183project.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private JMapper<UserResponse, User> mapper;

    public UserDetailsServiceImpl() {
        //this.mapper = new JMapper<>(UserResponse.class, User.class);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public List<UserResponse> getAllUsers(){
       List<User> users = userRepository.findAll();
        List<UserResponse> res = users.stream().map(temp-> this.mapper.getDestination(temp)).collect(Collectors.toList());
        return res;

    }

    public UserResponse changeRoleFromUser(Long userId, Set<Role> role){
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userId));;
        user.setRoles(role);
        userRepository.save(user);
        return this.mapper.getDestination(user);

    }

}
