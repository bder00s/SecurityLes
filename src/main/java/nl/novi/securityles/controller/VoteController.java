package nl.novi.securityles.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/votes")
public class VoteController {


    ArrayList<String> voteList = new ArrayList<>();

    @PostMapping("/yourvote")
    public String addVote(@RequestParam String partij) {
        voteList.add(partij);
        return partij;
    }

    @GetMapping("/votings")
    public ArrayList<String> getVoteList() {
        return (voteList);
    }
}
