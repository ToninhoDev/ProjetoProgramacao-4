package br.com.voting.vote.controllers;

import br.com.voting.vote.dtos.VoteDTO;
import br.com.voting.vote.enums.TypeVote;
import br.com.voting.vote.models.Vote;
import br.com.voting.vote.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;
    @PostMapping
    public ResponseEntity<Void> registerVote(@RequestBody VoteDTO objDTO) {
        Vote objVote = voteService.fromDTO(objDTO);
        objVote = voteService.registerVote(objVote);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(objVote.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/countvotes/{topicId}")
    public ResponseEntity<Map<TypeVote, Integer>> resultVote(@PathVariable Long topicId ) {
        Map<TypeVote, Integer> voteCount = voteService.contVotesTopic(topicId);
        return ResponseEntity.ok(voteCount);
    }




}
