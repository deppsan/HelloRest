package naranya.com.hellorest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import naranya.com.hellorest.models.Character;

/**
 * Created by Naranya on 11/3/2015.
 */
public class CharactersAdapter extends BaseAdapter {
    private ArrayList<Character>items;
    private Context ctx;

    public CharactersAdapter(ArrayList<Character> items, Context ctx) {
        this.items = items;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

          convertView= LayoutInflater.from(ctx).inflate(android.R.layout.simple_list_item_1,null);
            TextView textView = (TextView)convertView.findViewById(android.R.id.text1);


        Character character= items.get(position);
        if (character!=null){

            textView.setText(character.getName());
        }





        return convertView;




    }
}
