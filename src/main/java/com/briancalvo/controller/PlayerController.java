package com.briancalvo.controller;

import com.briancalvo.domain.Player;
import com.briancalvo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Player updatePlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public Player findById(@PathVariable Long id) {
        Player player = playerRepository.findOne(id);
        return player;
    }

    @RequestMapping(value = "/byPoints/{num}",
            method = RequestMethod.GET)
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num) {
        return playerRepository.findByPointsGreaterThan(num);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.delete(id);
    }
}
