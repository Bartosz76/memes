package com.bm.gifdemo.repository;

import com.bm.gifdemo.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {

    public static List<Gif> getGifs() {
        return ALL_GIFS;
    }

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true,2),
            new Gif("ben-and-mike", "mika", true, 1),
            new Gif("book-dominos", "mem", false,0),
            new Gif("compiler-bot", "bot", true,2),
            new Gif("cowboy-coder", "code", false,1),
            new Gif("infinite-andrew", "andrew", true,2)


    );

    public Gif getGifByName(String name){
        for (Gif gif : getGifs()){
            if (gif.getName().equals(name)){
                return gif;

            }

        }
        return null;



    }

    public List<Gif> getGifsByCategoryId(int id){

        List<Gif> listCategoryId = new ArrayList<>();
        for (Gif gif : getGifs()){
            if (gif.getCategoryId() == id){
                listCategoryId.add(gif);
            }

        }
        return listCategoryId;

    }
}
