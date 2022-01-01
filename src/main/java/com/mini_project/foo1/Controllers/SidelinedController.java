package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Country;
import com.mini_project.foo1.Models.Primitives.Sidelined;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/sidelined")
@CrossOrigin
public class SidelinedController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Cheap_Translate cheap_translate=new Cheap_Translate();

    @GetMapping
    public List<Sidelined> getCountries(@PathVariable String lang,
                                      @RequestParam(required = false) String coach,
                                      @RequestParam(required = false) String player ){

        final String[] textATraduire = {""};
        List<Sidelined> countries=api_football_beta.getSidelined(coach,player);

        countries.forEach(c-> textATraduire[0] +=c.getType()+"|");

        //TextTraduit textTraduit= cheap_translate.request(lang,textATraduire[0]);
        String[] countriesTranlated=cheap_translate.request(lang,textATraduire[0]).split("\\|");
        for(int i=0; i<countries.size();i++){
            countries.get(i).setType(countriesTranlated[i]);
        }
        return countries;
    }




}