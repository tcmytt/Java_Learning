package vn.LearningSpring.HelloWorld.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Caculator caculator;

    @Autowired
    public DemoController(@Qualifier("getCaculator") Caculator caculator) {
        this.caculator = caculator;
    }

    @GetMapping("/Caculator")
    public String index(@RequestParam("value") int x) {
        return "Gap 2 lan cua " + x + " la " + caculator.add(x,x);
    }
}
