package gibb.m183.m183project.controllers;

import gibb.m183.m183project.models.Role;
import gibb.m183.m183project.payload.request.UserRequest;
import gibb.m183.m183project.payload.response.UserResponse;
import gibb.m183.m183project.repository.RoleRepository;
import gibb.m183.m183project.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/api/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserResponse> changeUserRole(){
         return userDetailsService.getAllUsers();
    }

    @PutMapping("/api/user/role/{userId}/{newRole}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponse changeUserRole(@PathVariable Long userId, String newRole){
        Set<Role> roles = (Set<Role>) roleRepository.findByName(newRole).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return userDetailsService.changeRoleFromUser(userId, roles);
    }
}
