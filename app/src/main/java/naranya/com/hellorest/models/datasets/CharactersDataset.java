package naranya.com.hellorest.models.datasets;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import naranya.com.hellorest.models.Character;

/**
 * Created by Naranya on 11/3/2015.
 */
public class CharactersDataset {
    private Data data;

    public CharactersDataset() {

    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        @SerializedName("results")
        ArrayList<Character>characterses;

        public Data() {
        }

        public ArrayList<Character> getCharacterses() {
            return characterses;
        }

        public void setCharacterses(ArrayList<Character> characterses) {
            this.characterses = characterses;
        }
    }

}
