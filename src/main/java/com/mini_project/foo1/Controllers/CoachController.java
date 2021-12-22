package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Coach;
import com.mini_project.foo1.Models.Team;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/coachs")
@CrossOrigin
public class CoachController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Cheap_Translate cheap_translate=new Cheap_Translate();

    @GetMapping
    public List<Coach> getTeams(@PathVariable String lang,
                                @RequestParam(required = false) String search,
                                @RequestParam(required = false) String team,
                                @RequestParam(required = false) String id ){

        List<Coach> coaches=api_football_beta.getCoach(id,team,search);
        final String[] textATraduire = {""};
        coaches.forEach(c-> textATraduire[0] +=c.getNationality()+"|");
        String[] countriesTranlated=cheap_translate.request(lang,textATraduire[0]).split("\\|");
        for(int i=0; i<coaches.size();i++){
            coaches.get(i).setNationality(countriesTranlated[i]);
        }
        return coaches;}
}
