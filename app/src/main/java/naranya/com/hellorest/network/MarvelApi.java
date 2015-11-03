package naranya.com.hellorest.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.google.gson.Gson;

import org.json.JSONObject;

import naranya.com.hellorest.HelloRest;
import naranya.com.hellorest.models.datasets.CharactersDataset;

/**
 * Created by Naranya on 11/3/2015.
 */
public class MarvelApi {
    private static final String PATH="http://gateway.marvel.com:80/v1/public/";

    public MarvelApi() {
    }

    public void getCharacters(Context ctx, final MarvelApiListener listener){
        String url =PATH+"characters";

        JsonRequestCustom reques= new JsonRequestCustom(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                CharactersDataset charactersDataset= new Gson().fromJson(response.toString(), CharactersDataset.class);
                listener.onResponseCharacters(charactersDataset.getData().getCharacterses());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.toString());
                listener.onErrorResponseCharacters(error.networkResponse.statusCode,"error");
            }
        });
        HelloRest.getInstance(ctx).addToRequestQueue(reques);
    }


}
