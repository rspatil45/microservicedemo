package com.rspatil.microservice.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean //Indicates that a method produces a bean to be managed by the Spring container
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
	{
//		Function<PredicateSpec, Buildable<Route>> routeFunction
//		= p -> p.path("/get")
//			  .filters(f -> f
//					  		.addRequestHeader("Myheader", "my header")
//					  		.addRequestParameter("param", "paramvalue"))
//			  .uri("http://httpbin.org:80");
//		return builder.routes()
//				.route(routeFunction)
//				.build();
// writing inline lambda function		
		return builder.routes()
				.route(p -> p.path("/get")
				.filters(f -> f
						.addRequestHeader("MyHeader", "MyURI")
						.addRequestHeader("Param", "Myvalue"))
				.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**") //these requests should redirect to service which as name as given below in euraka server
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-new/**") 
						.filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
	}
}
//here segment is whatever we find in /currency-conversion-new url will be append to /currency-conversion