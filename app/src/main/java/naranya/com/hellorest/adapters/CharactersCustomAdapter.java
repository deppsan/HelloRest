package naranya.com.hellorest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import naranya.com.hellorest.R;
import naranya.com.hellorest.models.Character;

/**
 * Created by Naranya on 11/3/2015.
 */
public class CharactersCustomAdapter extends BaseAdapter {
    private ArrayList<Character>items;
    private Context ctx;

    public CharactersCustomAdapter(ArrayList<Character> items, Context ctx) {
        this.items = items;
        this.ctx = ctx;
    }
     class CharacterViewHolder{
        TextView tvName;
        ImageView imgCharacter;

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
        CharacterViewHolder viewHolder=null;
        if (convertView==null){
             viewHolder= new CharacterViewHolder();

            convertView= LayoutInflater.from(ctx).inflate(R.layout.item_character,null);
             viewHolder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            viewHolder.imgCharacter=(ImageView)convertView.findViewById(R.id.imgCharacter);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (CharacterViewHolder) convertView.getTag();
        }

        Character character= items.get(position);
        if (character!=null){

            viewHolder.tvName.setText(character.getName());
            Glide.with(ctx).load(character.getThumbnail().getThumbnail()).into(viewHolder.imgCharacter);
        }
        return convertView;




    }
}
