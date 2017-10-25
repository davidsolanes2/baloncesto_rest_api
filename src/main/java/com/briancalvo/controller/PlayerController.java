package com.briancalvo.controller;

import com.briancalvo.domain.Player;
import com.briancalvo.domain.Position;
import com.briancalvo.repository.PlayerRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable Long id) {
        Player player = playerRepository.findOne(id);
        return player;
    }

    @GetMapping("/byPoints/{num}")
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num) {
        return playerRepository.findByPointsGreaterThan(num);
    }

    @GetMapping("/orderByPoints")
    public List<Player> findByPointOrderByPoints() {
        return playerRepository.findAllByOrderByPoints();
    }

    @GetMapping("/byPointsBetween/{min},{max}")
    public List<Player> findByPointsBetween(@PathVariable Integer min, @PathVariable Integer max) {
        return playerRepository.findByPointsBetween(min, max);
    }

    @GetMapping("/plalyersByPosition")
    public Map<Position, Collection<Player>> playersByPosition() {
        List<Player> players = playerRepository.playersByPosition();

        ListMultimap<Position, Player> playerMultiMap = ArrayListMultimap.create();

        for (Player p: players) {
            playerMultiMap.put(p.getPosition(), p);
        }

        return playerMultiMap.asMap();
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.delete(id);
    }
}
