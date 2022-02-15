package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Foo1Application;
import com.mini_project.foo1.Models.Country;
import com.mini_project.foo1.Models.TextTraduit;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import com.mini_project.foo1.Services.API.Keys;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/pays")
@CrossOrigin
public class CountryController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Cheap_Translate cheap_translate=new Cheap_Translate();

    @GetMapping
    public List<Country> getCountries(@PathVariable String lang,
                              @RequestParam(required = false) String search,
                                      @RequestParam(required = false) String code,
                              @RequestParam(required = false) String name ){

        final String[] textATraduire = {""};
        List<Country> countries=api_football_beta.getCountries(name,search,code);

        countries.forEach(c-> textATraduire[0] +=c.getName()+"|");

       //TextTraduit textTraduit= cheap_translate.request(lang,textATraduire[0]);
       String[] countriesTranlated=cheap_translate.request(lang,textATraduire[0]).split("\\|");
       for(int i=0; i<countries.size();i++){
           countries.get(i).setName(countriesTranlated[i]);
       }
  System.out.println(code);
        return countries;
    }




}
