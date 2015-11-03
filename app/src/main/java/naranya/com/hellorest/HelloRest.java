package naranya.com.hellorest;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Naranya on 11/3/2015.
 */
public class HelloRest  {
    public static final String TAG = HelloRest.class.getSimpleName();

    private static HelloRest ourInstance ;
    private RequestQueue mRequestQueue;
    private Context context;

    public HelloRest(Context ctx) {
        context=ctx;
    }



    public static HelloRest getInstance(Context ctx) {
        if (ourInstance!=null){
            ourInstance.context=ctx;

        }else{
            ourInstance=new HelloRest(ctx);

        }
        return ourInstance;
    }



    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


    public void cancelAllRequestVolley() {
        getRequestQueue().cancelAll(context);
    }

}
