package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Fixture;
import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{lang}/fixtures/statistiques")
@CrossOrigin
public class FixtureStatisticController {
    private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
    private final Cheap_Translate cheap_translate=new Cheap_Translate();
    @GetMapping
    public void getFixture(@PathVariable String lang,
                                    @RequestParam(required = false) String venue,
                                    @RequestParam(required = false) String id){
        Runnable runnable=()->{};
        Thread thread=new Thread(runnable);
        thread.start();

    }
}
