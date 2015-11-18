package view;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

	public static void main(String args[]) throws IOException {

		Configuration config = new Configuration();
		config.setDirectoryForTemplateLoading(new File("src/main/resources"));
		config.setDefaultEncoding("UTF-8");

		FreeMarkerEngine freeEngine = new FreeMarkerEngine();
		freeEngine.setConfiguration(config);

		get("/hello", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "CNRS BORDEAUX");
			attributes.put("user", "coucou");
			return new ModelAndView(attributes, "hello.ftl");
		}, freeEngine);

		post("/hello", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Hello World!");
			return new ModelAndView(attributes, "hello.ftl");
		}, freeEngine);

	}

}