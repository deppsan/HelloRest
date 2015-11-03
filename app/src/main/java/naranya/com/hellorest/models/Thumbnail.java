package naranya.com.hellorest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Naranya on 11/3/2015.
 */
public class Thumbnail {
    private String path;
    private String extension;

    public Thumbnail() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getThumbnail(){
        return this.path+"."+this.extension;
    }
}
