package com.mini_project.foo1.Controllers;


import com.mini_project.foo1.Models.Primitives.PlayerPagination;
import com.mini_project.foo1.Models.Standing;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/classement")
@CrossOrigin
public class StandingController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    @GetMapping
    public Standing getPlayer(@PathVariable String lang,
                                    @RequestParam(required = false) String team,
                                    @RequestParam(required = false) String season,
                                    @RequestParam(required = false) String league){

        return api_football_beta.getStanding(team,season,league);
    }
}