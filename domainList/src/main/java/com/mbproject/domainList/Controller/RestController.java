package com.mbproject.domainList.Controller;

import com.mbproject.domainList.model.Domain;
import com.mbproject.domainList.model.DomainList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/domain")
public class RestController {

    List<Domain> domain = Arrays.asList(
            new Domain("a","b","c","d",true,"a","b","c","d","e"),
            new Domain("a","b","c","d",false,"a","b","c","d","e"),
            new Domain("a","b","c","d",true,"a","b","c","d","e")
            );

    @GetMapping("/list")
    private DomainList getDomainList(){
        DomainList domainList = new DomainList();
        domainList.setDomains(domain);
        return domainList;
    }

}
