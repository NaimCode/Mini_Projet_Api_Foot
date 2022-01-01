package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Primitives.Trophie;
import com.mini_project.foo1.Models.Team_statistique;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/trophies")
@CrossOrigin
public class TrophieController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    @GetMapping
    public List<Trophie> getTeams(@PathVariable String lang,
                                  @RequestParam(required = false) String coach,
                                  @RequestParam(required = false) String player){


        return api_football_beta.getTrophie(coach,player);
    }
}
