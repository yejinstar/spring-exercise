package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        log.info("getName으로 요청이 들어왔습니다.");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String variable){
        log.info("getVariable1로 요청이 들어왔습니다. variable:{}", variable); //http://localhost:8080/api/v1/get-api/variable1/variable1
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getReuquestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2")
    public String getReuquestParam2(
            @RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getReuquestParam3(
            MemberDto memberDto){
        return memberDto.toString();
    }
}