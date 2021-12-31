package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Primitives.Player;
import com.mini_project.foo1.Models.Primitives.PlayerPagination;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/joueurs")
@CrossOrigin
public class PlayerController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    @GetMapping
    public PlayerPagination getPlayer(@PathVariable String lang,
                                      @RequestParam(required = false) String team,
                                      @RequestParam(required = false) String id,
                                      @RequestParam(required = false) String season,
                                      @RequestParam(required = false) String league,
                                      @RequestParam(required = false) String page){

return api_football_beta.getPlayers(team,season,league,id,page);
    }
}
