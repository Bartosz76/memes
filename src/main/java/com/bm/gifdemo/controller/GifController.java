package com.bm.gifdemo.controller;

import com.bm.gifdemo.model.Gif;
import com.bm.gifdemo.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static com.bm.gifdemo.repository.GifRepository.getGifs;


@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/")
    public String listGifsHome(ModelMap modelMap) {

        List<Gif> gifList = gifRepository.getGifs();

        modelMap.put("gifs", gifList);

        return "home";
    }

    @GetMapping("/favorites")
    public List<Gif> listGifsFavorites(ModelMap modelMap) {
        List<Gif> gifFavorites = new ArrayList<>();
        for (int i = 0; i < getGifs().size(); i++) {
            if (getGifs().get(i).getFavorite()) {
                gifFavorites.add(getGifs().get(i));
            }


        }
        modelMap.put("gifs", gifFavorites);
        return gifFavorites;
    }

    @GetMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {

        Gif gif = gifRepository.getGifByName(name);

        modelMap.put("gif", gif);

        return "gif-details";











    /* @ResponseBody // to sprawia, że wyświetli się napis z returna
    @GetMapping("/test")

    public String listGifs(){


        return getAllGifs().toString(); // getAllGifs jest listą, a my chcemy Stringa. Ponoć @ResponseBody źle działa bez tego Stringa, CHYBA...


    }

    @ResponseBody
    @GetMapping("/test1")
    public String listGif(){

        for (int i = 0; i < getAllGifs().size(); i++){ // OMFG SAM TO WYMYSLILES (albo jako jedna z nielicznych osob, albo moze w ogole jedyny. Jedyny sie zglosiles).
            if (getAllGifs().get(i).getUsername().equals("mika")){

             return getAllGifs().get(i).toString();
            }

        }
        return null;


    }

    @ResponseBody
    @GetMapping("/test2")
    public List<Gif> listGif2(){ // omgomg to całe zrobiłeś sam jak pierwszy dobrze (z tym wyjatkiem, ze zwrociles jeden wynik, a nie cala liste).
                                    // potem z drobną podpowiedzią zrobiłeś sam :)

                                    // ja robie metode, ktora zwraca liste. Moglbym zrobic zwracanie Stringa i dalej i tak zrobic sobie liste...
                                    // wowczas wystarczy tylko, ze w "return list2;" dodasz ".toString();" i bedzie dzialac tak samo

        List<Gif> list2 = new ArrayList<>();

        for (int i = 0; i <getAllGifs().size(); i++){
            if (getAllGifs().get(i).getFavorite().equals(false)){ // Łukasz stwierdzil, ze tu musi byc "equals" zamiast "==", bo to duzy Boolean a nie maly boolean.
                list2.add(getAllGifs().get(i));


            }


        }
        return list2;

        /* TO NA GÓRZE MOŻNA TEŻ ZROBIC TAK: (to na dole to jest "For Each" zamiast "For i"

        public String listGifs3(){
        List<Gif> allGids = gerAllGifs();
        List<Gif> unfavorites = new ArrayList<>();
        for(Gif x : allGifs){
        if(!x.getFavorite()){
        unfavorites.add(x);
        }
        }
        return unfavorites.toString();
        }

         */


    }
}





