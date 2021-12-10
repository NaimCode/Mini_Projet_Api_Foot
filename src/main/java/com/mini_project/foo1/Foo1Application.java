package com.mini_project.foo1;

import com.mini_project.foo1.Services.API.Api_Football_Beta;
import com.mini_project.foo1.Services.API.Cheap_Translate;
import com.mini_project.foo1.Services.Utils.Convertion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Foo1Application {

	private final Cheap_Translate cheap_translate=new Cheap_Translate();
	private final Api_Football_Beta api_football_beta=new Api_Football_Beta();
	private final Convertion convertion =new Convertion();

	public static void main(String[] args) {
		SpringApplication.run(Foo1Application.class, args);
	}


}
