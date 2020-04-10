package com.cadastral.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourcesController {

    @GetMapping(value = "api-cadastral/source")
    public String getSourcesLink(){
        return "<p style=\"margin-left:5em; margin-top:3em;\">" +
                "O código fonte desta API está disponível em: <br><br><a style=\"margin-left:2em;\" href=\"https://github.com/danpatrocinio/api-cadastral\">https://github.com/danpatrocinio/api-cadastral</a>" +
                "<br><br>" +
                "O database desta API pode ser acessado em: <br><br><a style=\"margin-left:2em;\" href=\"http://localhost:8080/h2\">http://localhost:8080/h2</a> <small style=\"margin-left:1em;\">(senha em branco)</small>";
    }

}
