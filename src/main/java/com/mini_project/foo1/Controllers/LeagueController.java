package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Country;
import com.mini_project.foo1.Models.League;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/ligues")
@CrossOrigin
public class LeagueController {
     private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Api_Football_Beta cheap_translate=new Api_Football_Beta();


    @GetMapping
    public List<League> getLeagues(@PathVariable String lang,
                                   @RequestParam(required = false) String search,
                                   @RequestParam(required = false) String current,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String type,
                                   @RequestParam(required = false) String id,
                                   @RequestParam(required = false) String season,
                                   @RequestParam(required = false) String team,
                                   @RequestParam(required = false) String country){



        return  api_football_beta.getLeagues(id,name,search,country,season,type,current,team);
    }
}
