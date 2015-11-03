package naranya.com.hellorest.network;

import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.request.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naranya on 11/3/2015.
 */
public class JsonRequestCustom extends JsonObjectRequest {

    private final Map<String, Object> params;

    public JsonRequestCustom(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
        this.params=new HashMap<>();
        params.put("apikey","51c307cc021b1dcda8704f8dd78d1406");
        params.put("ts","1");
        params.put("hash","84019777a15f2db69a0835d67e5684f9");
    }
    public JsonRequestCustom(int method, String url,HashMap<String,Object> params, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
        this.params=new HashMap<>();
        params.put("apikey","51c307cc021b1dcda8704f8dd78d1406");
        params.put("ts","1");
        params.put("hash","84019777a15f2db69a0835d67e5684f9");
        params.putAll(params);
    }
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> params = new HashMap<String, String>();
        return params;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> p = new HashMap<>();
        for(Map.Entry<String, Object> entry : params.entrySet()){
            p.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return p;
    }

}
