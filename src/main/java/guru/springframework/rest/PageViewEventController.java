package guru.springframework.rest;

import guru.springframework.domain.PageView;
import guru.springframework.model.events.PageViewEvent;
import guru.springframework.repositories.PageViewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PageViewEventController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private PageViewsRepository pageViewsRepository;

    @Autowired
    public PageViewEventController(PageViewsRepository pageViewsRepository) {
        this.pageViewsRepository = pageViewsRepository;
    }

    @RequestMapping("/greeting")
    public PageView greeting(@RequestParam(value="name", defaultValue="World") String name) {
        PageView pageView = new PageView();
        pageView.setCorrelationId("32423424");
        pageView.setPageUrl("www.google.de");
        pageView.setPageViewDate(new Date());
        return this.pageViewsRepository.save(pageView);
    }
}
