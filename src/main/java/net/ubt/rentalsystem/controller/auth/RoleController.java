package net.ubt.rentalsystem.controller.auth;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.auth.CreateRoleDto;
import net.ubt.rentalsystem.entity.user.CustomRole;
import net.ubt.rentalsystem.service.auth.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<CustomRole>> getRolesByUserId(@PathVariable UUID userId) {
        List<CustomRole> roles = roleService.getRolesByUserId(userId);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createRole(@RequestBody CreateRoleDto createRoleDto) {
        roleService.createRole(createRoleDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{roleId}/add-user/{userId}")
    public ResponseEntity<HttpStatus> addUserToRole(@PathVariable UUID roleId, @PathVariable UUID userId) {
        roleService.addUserToRole(roleId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}/remove-user/{userId}")
    public ResponseEntity<HttpStatus> removeUserFromRole(@PathVariable UUID roleId, @PathVariable UUID userId) {
        roleService.removeUserFromRole(roleId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
