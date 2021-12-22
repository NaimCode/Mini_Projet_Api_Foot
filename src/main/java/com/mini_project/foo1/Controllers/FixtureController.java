package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Fixture;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/fixtures")
@CrossOrigin
public class FixtureController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Cheap_Translate cheap_translate=new Cheap_Translate();
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
        List<Fixture> fixtures=api_football_beta.getFixtures(id,status,from,to,date,live,last,round,season,league,team);
        final String[] textATraduire = {""};
        fixtures.forEach(c-> textATraduire[0] +=c.getStatus()+":"+c.getLeague_v2().getRound()+"|");
        String[] countriesTranlated=cheap_translate.request(lang,textATraduire[0]).split("\\|");
        for(int i=0; i<fixtures.size();i++){
            String[] elements=countriesTranlated[i].split("\\:");
            fixtures.get(i).setStatus(elements[0]);
            fixtures.get(i).getLeague_v2().setRound(elements[1]);
        }
        return  fixtures;
    }
}
