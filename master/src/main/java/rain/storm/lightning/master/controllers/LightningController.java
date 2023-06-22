package rain.storm.lightning.master.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightningController {

    @GetMapping("/crackle")
    public String crackle(){
        return "⚡ boom, crackle crackle ⚡";
    }
}
