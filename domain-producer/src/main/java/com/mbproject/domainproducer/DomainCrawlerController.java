package com.mbproject.domainproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainCrawlerController {


  private DomainCrawlerService domainCrawlerService;

  public DomainCrawlerController(DomainCrawlerService domainCrawlerService) {
    this.domainCrawlerService = domainCrawlerService;
  }

  @GetMapping("/lookup")
  public String lookup() {
    domainCrawlerService.crawl();
    return "Domain crawler has scrapped your data";
  }
}
