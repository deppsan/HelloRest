package naranya.com.hellorest.network;

import java.util.ArrayList;

import naranya.com.hellorest.models.Character;


/**
 * Created by Naranya on 11/3/2015.
 */
public interface MarvelApiListener {

     void onResponseCharacters(ArrayList<Character> characterses);
    void onErrorResponseCharacters(int statusCode,String message);
}
