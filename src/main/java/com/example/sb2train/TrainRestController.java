package com.example.sb2train;

import java.io.Serializable;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("train")
public class TrainRestController {

	@SuppressWarnings("serial")
	public static class User implements Serializable {
		public User() {
			
		}
		public User(User user) {
			this.name = "Mr." + user.name;
			this.age = ++user.age;
		}
		public String name;
		public String getName() {
			return name;
		}
		public void setName(String value) {
			this.name = value;
		}
		public int age;
		public int getAge() {
			return age;
		}
		public void setAge(int value) {
			this.age = value;
		}
		@Override
		public String toString() {
			return "user{name:"+name+",age:"+age+"}";
		}
	}
	
    @GetMapping("/")
    Flux<String> hello() {
        return Flux.just("Hello", "World");
    }
    
    @GetMapping("/stream")
    Flux<Map<String, Integer>> stream() {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1); // Java8の無限Stream
        return Flux.fromStream(stream.limit(10))
        		.zipWith(Flux.interval(Duration.ofSeconds(1)))
                .map(tuple -> Collections.singletonMap("value", tuple.getT1()));
    }
    
    @PostMapping(value="/echo")
    Mono<String> echo(@RequestBody Mono<String> stream){
    	return stream.map(String::toUpperCase);
    }
    
    @PostMapping("simpletext")
    String echo(@RequestBody String body) {
    	System.out.println(body);
    	System.out.println(body.toUpperCase());
    	return body.toUpperCase();
    }
    
    @PostMapping("pac")
    Mono<String> echo(ServerRequest request) {
    	return request.bodyToMono(String.class);
    }
    
    @PostMapping("/stream")
    Flux<User> stream(@RequestBody Flux<TrainRestController.User> users) {
    	return users.map(u->new User(u));
//        return body.map(m -> Collections.singletonMap("double", m.get("value") * 2));
    }
}
