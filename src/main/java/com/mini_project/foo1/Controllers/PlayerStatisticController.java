package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.FixtureStatistic;
import com.mini_project.foo1.Models.PlayerStatistic;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/players/statistics")
@CrossOrigin
public class PlayerStatisticController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Cheap_Translate cheap_translate=new Cheap_Translate();
    @GetMapping
    public List<PlayerStatistic> getFixture(@PathVariable String lang,
                                            @RequestParam(required = false) String team,
                                            @RequestParam() String season,
                                            @RequestParam(required = false) String league,
                                            @RequestParam(required = false) String id) throws InterruptedException {




        return api_football_beta.getPlayerStatistic(id,team,league,season);
    }
}