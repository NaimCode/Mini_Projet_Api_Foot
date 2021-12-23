package com.mini_project.foo1.Controllers;

import com.mini_project.foo1.Models.Fixture;
import com.mini_project.foo1.Models.FixtureStatistic;
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
    public FixtureStatistic getFixture(@PathVariable String lang,
                                       @RequestParam(required = false) String venue,
                                       @RequestParam(required = false) String id) throws InterruptedException {

FixtureStatistic fixtureStatistic=api_football_beta.getFixtureStatistic(id,venue);
//
//        final String[] textATraduire = {""};
//        final int[] index={0};
//        fixtureStatistic.getFixtureEvents().forEach(c->{
//            if(index[0]==0) textATraduire[0] +=c.getType()+":"+c.getDetail()+":"+c.getComments();
//            else textATraduire[0] +=">"+c.getType()+":"+c.getDetail()+":"+c.getComments();
//            index[0]++;
//
//        });
//        textATraduire[0]+="=";
//         index[0]=0;
//        fixtureStatistic.getFixtureStatistic_v1s().get(0).getStatistics().forEach(c-> {
//            if(index[0]==0)
//            textATraduire[0] +=c.getType();
//            else
//                textATraduire[0] +="|"+c.getType();
//            index[0]++;
//        });
//        textATraduire[0]+="=";
//        index[0]=0;
//        fixtureStatistic.getFixtureStatistic_v1s().get(0).getStatistics().forEach(c-> {
//            if(index[0]==0)
//                textATraduire[0] +=c.getType()+"|";
//            else
//                textATraduire[0] +="|"+c.getType();
//            index[0]++;
//        });
//
//        String[] countriesTranlated=cheap_translate.request(lang,textATraduire[0]).split("\\=");
//
//
//            String[] events=countriesTranlated[0].split("\\>");
//            String[] statistics1=countriesTranlated[1].split("\\|");
//            String[] statistics2=countriesTranlated[2].split("\\|");
//
//            for (int i=0;i<fixtureStatistic.getFixtureEvents().size();i++){
//                String[] events_els=events[i].split("\\:");
//                fixtureStatistic.getFixtureEvents().get(i).setType(events_els[0]);
//                fixtureStatistic.getFixtureEvents().get(i).setDetail(events_els[1]);
//                fixtureStatistic.getFixtureEvents().get(i).setComments(events_els[2]);
//            }
//        for (int i=0;i<fixtureStatistic.getFixtureStatistic_v1s().get(0).getStatistics().size();i++){
//
//            fixtureStatistic.getFixtureStatistic_v1s().get(0).getStatistics().get(i).setType(statistics1[i]);
//            fixtureStatistic.getFixtureStatistic_v1s().get(1).getStatistics().get(i).setType(statistics2[i]);
//        }
//

        return fixtureStatistic;
    }
}
