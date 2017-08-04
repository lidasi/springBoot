package com.lidasi.gril;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    /*@Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;*/

    @Autowired
    private GrilProperties grilProperties;

    /*获取http://localhost:8080/hello/100/say 类型的id*/
    /*@RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "id: " + id;
        //return grilProperties.getCupSize();
    }*/

    /*获取http://localhost:8080/hello/say?id=100 类型的id*/
    //@RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "id: " + myId;
        //return grilProperties.getCupSize();
    }
}
