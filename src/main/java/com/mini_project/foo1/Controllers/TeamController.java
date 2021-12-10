package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Team;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/equipes")
public class TeamController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();


    @GetMapping
    public List<Team> getTeams(@PathVariable String lang,
                               @RequestParam(required = false) String search,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String id,
                               @RequestParam(required = false) String season,
                               @RequestParam(required = false) String league,
                               @RequestParam(required = false) String country ){
        return api_football_beta.getTeams(id,name,search,country,season,league);
    }
}
