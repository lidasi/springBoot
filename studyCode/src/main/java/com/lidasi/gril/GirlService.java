package com.lidasi.gril;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(33);
        girlA.setCupSize("D");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(30);
        girlB.setCupSize("SSSS");
        girlRepository.save(girlB);
    }
}
