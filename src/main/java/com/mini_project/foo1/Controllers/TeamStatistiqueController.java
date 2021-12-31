package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Team;
import com.mini_project.foo1.Models.Team_statistique;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/equipes/statistiques")
@CrossOrigin
public class TeamStatistiqueController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();


    @GetMapping
    public Team_statistique getTeams(@PathVariable String lang,
                                           @RequestParam() String team,
                                           @RequestParam() String season,
                                           @RequestParam() String league){


        return api_football_beta.getTeamStatistique(team,season,league);
    }
}
