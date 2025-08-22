package org.hunterxdk.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    /**
     * Say hello to the user.
     *
     * @return a friendly greeting
     */
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}
