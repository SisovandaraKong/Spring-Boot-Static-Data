package dara.istad.spring.project1.spring_project1.controller;


import dara.istad.spring.project1.spring_project1.dto.UserCreateDto;
import dara.istad.spring.project1.spring_project1.dto.UserUpdateDto;
import dara.istad.spring.project1.spring_project1.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public Map<String, Object> getAllUsers() {
        userService.getAllUsers();
        return Map.of("users", userService.getAllUsers());
    }

    @GetMapping("/{uuid}")
    public Map<String, Object> getUserByUuid(@PathVariable String uuid) {
        userService.getUserByUuid(uuid);
        return Map.of("users", userService.getUserByUuid(uuid));
    }
    @PostMapping
    public Map<String, Object> addUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        userService.addUser(userCreateDto);
        return Map.of("users", userCreateDto);
    }
    @DeleteMapping("/{uuid}")
    public Map<String, Object> deleteUserByUuid(@PathVariable String uuid) {
        userService.deleteUserByUuid(uuid);
        return Map.of("users", userService.getAllUsers());
    }
    @PutMapping("/{uuid}")
    public Map<String,Object> updateUserByUuid(@PathVariable String uuid, @RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUserbyUuid(uuid, userUpdateDto);
        return Map.of("users", userService.getAllUsers());
    }
    @GetMapping("/email")
    public Map<String, Object> getUserByEmail(@RequestParam String email,@RequestParam String name) {
        return Map.of("users", userService.getUserByEmail(email,name));
    }
}
