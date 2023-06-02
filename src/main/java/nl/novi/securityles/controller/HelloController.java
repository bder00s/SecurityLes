package nl.novi.securityles.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            // Als het object aanwezig is, maakt Spring van het type Object het type UserDetails
            UserDetails userDetailsObject = (UserDetails) authentication.getPrincipal();
            return "Hello " + userDetailsObject.getUsername();
        } else {
            return "Hello stranger";
        }

    }
    @GetMapping("/secret")
    public String tellSecret(){
        return "This is a secret...";
    }
}
