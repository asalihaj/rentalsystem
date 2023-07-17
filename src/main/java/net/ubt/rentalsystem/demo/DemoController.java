package net.ubt.rentalsystem.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    @PreAuthorize("hasAuthority('DEMO:LIST')")
    public ResponseEntity<String> getObjectList() {
        return ResponseEntity.ok("Hello from get request list");
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('DEMO:DETAILS')")
    public ResponseEntity<String> getObjectDetails() {
        return ResponseEntity.ok("Hello from get request details");
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DEMO:CREATE')")
    public ResponseEntity<String> createObject() {
        return ResponseEntity.ok("Create object");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('DEMO:UPDATE')")
    public ResponseEntity<String> updateObject() {
        return ResponseEntity.ok("Update object");
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('DEMO:DELETE')")
    public ResponseEntity<String> deleteObject() {
        return ResponseEntity.ok("Delete object");
    }
}
