package zack.san.ceft.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import zack.san.ceft.entities.Anime;
import zack.san.ceft.services.AnimeServiceImpl;


import java.util.HashMap;
import java.util.Map;

@Controller
public class AnimeController {

    private final AnimeServiceImpl animeService;

    @Autowired
    public AnimeController(AnimeServiceImpl animeService) {
        this.animeService = animeService;
    }


    @GetMapping("/MyAnimeList")
    public ModelAndView getAnimelist(){
        String viewName = "animelist";
        Map<String,Object> model =  new HashMap<>();
        model.put("animelist",animeService.findAll());
        model.put("numberOfAnime",animeService.findAll().size());
        return  new ModelAndView(viewName,model);
    }

    @GetMapping("/submitNew")
    public ModelAndView submitNewAnime(){

        String viewName = "animeForm";
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("anime", new Anime());
        return new ModelAndView(viewName,model);
    }

    @PostMapping("/submitNew")
    public ModelAndView submitNewAnime(@Valid @ModelAttribute("anime") Anime anime, BindingResult bindingResult){

     if(bindingResult.hasErrors()){
            return new ModelAndView("animeForm");
     }
     animeService.save(anime);
     RedirectView redirect = new RedirectView();
     redirect.setUrl("/MyAnimeList");
     return new ModelAndView(redirect);
    }



    @GetMapping("/updateAnime")
    public ModelAndView updateAnime(@RequestParam Integer id){

        String viewName = "updateAnime";
        Map<String,Object> model = new HashMap<String,Object>();
        Anime anime = animeService.findById(id);
        model.put("anime", anime);
        return new ModelAndView(viewName,model);
    }


    @PostMapping("/updateAnime")
    public ModelAndView updateAnime(@Valid @ModelAttribute("anime") Anime anime,BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return new ModelAndView("animeForm");
        }
        animeService.update(anime);
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/MyAnimeList");
        return new ModelAndView(redirect);
    }


    @GetMapping("/deleteAnime")
    public ModelAndView deleteStudent(@RequestParam Integer id) {
        animeService.delete(id);
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/MyAnimeList");
        return new ModelAndView(redirect);
    }
























}
