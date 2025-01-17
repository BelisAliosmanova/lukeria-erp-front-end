package com.example.LukeriaFrontendApplication.config;

import com.example.LukeriaFrontendApplication.dtos.ClientDTO;
import com.example.LukeriaFrontendApplication.dtos.ClientUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "lukeria-erp-client-user", url = "${backend.base-url}/client-user")
public interface ClientUserClient {
    @PostMapping
    ClientUserDTO createClientUser(@RequestBody ClientUserDTO clientUserDTO, @RequestHeader("Authorization")String auth);
    @GetMapping
    List<ClientUserDTO> getAllClientUsers(@RequestHeader("Authorization") String auth);
    @GetMapping("/clients/no-users")
     List<ClientDTO> getAllClientWithNoUser(@RequestHeader("Authorization") String auth);
    @GetMapping("/{id}")
    ClientUserDTO getClientUser(@PathVariable Long id, @RequestHeader("Authorization")String auth);
    @PutMapping("/{id}")
    ClientUserDTO updateClientUser(@PathVariable Long id, @RequestBody ClientUserDTO clientUserDTO, @RequestHeader("Authorization")String auth);
    @DeleteMapping("/{id}")
    void deleteClientUser(@PathVariable Long id, @RequestHeader("Authorization")String auth);
    @DeleteMapping("/deleteByUserAndClient/{userId}/{clientId}")
     void deleteClientUser(@PathVariable Long userId, @PathVariable Long clientId, @RequestHeader("Authorization") String auth);
}
