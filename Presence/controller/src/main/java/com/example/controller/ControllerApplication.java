package com.example.controller;

import com.samskivert.mustache.Mustache;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}

	// Переопределить MustacheAutoConfiguration для поддержки defaultValue ("")
	@Bean
	public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader mustacheTemplateLoader, Environment environment) {
		MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
		collector.setEnvironment(environment);
	// значение по умолчанию
		Mustache.Compiler compiler = Mustache.compiler().defaultValue("")
				.withLoader(mustacheTemplateLoader)
				.withCollector(collector);
		return compiler;
	}
}
