package com.lidasi.gril;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private  GirlService girlService;

    /**
     * 查询所有信息列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return  girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return  girlRepository.save(girl);
    }

    /**
     * 查询一个数据
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一条数据
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getGirlAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PutMapping(value = "/girls/two")
    public void twoGirl(){
        girlService.insertTwo();
    }
}
