package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Fixture;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/fixtures")
@CrossOrigin
public class FixtureController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    @GetMapping
    public List<Fixture> getFixture(@PathVariable String lang,
                                    @RequestParam(required = false) String season,
                                    @RequestParam(required = false) String team,
                                    @RequestParam(required = false) String id,
                                    @RequestParam(required = false) String status,
                                    @RequestParam(required = false) String from,
                                    @RequestParam(required = false) String to,
                                    @RequestParam(required = false) String date,
                                    @RequestParam(required = false) String live,
                                    @RequestParam(required = false) String last,
                                    @RequestParam(required = false) String round,
                                    @RequestParam(required = false) String league
                                    ){
        return  api_football_beta.getFixtures(id,status,from,to,date,live,last,round,season,league,team);
    }
}
