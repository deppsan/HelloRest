package naranya.com.hellorest.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import naranya.com.hellorest.R;
import naranya.com.hellorest.adapters.CharactersAdapter;
import naranya.com.hellorest.adapters.CharactersCustomAdapter;
import naranya.com.hellorest.models.*;
import naranya.com.hellorest.models.Character;
import naranya.com.hellorest.network.MarvelApi;
import naranya.com.hellorest.network.MarvelApiListener;

public class CustomListActivity extends AppCompatActivity implements MarvelApiListener {
    private ListView listView;
    private ArrayList<Character> mcharacters;
    private CharactersCustomAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=(ListView)findViewById(R.id.list);

        mcharacters=new ArrayList<>();
        madapter= new CharactersCustomAdapter(mcharacters,this);
        listView.setAdapter(madapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListActivity.this,"you click this hero: "+mcharacters.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

        MarvelApi marvelApi= new MarvelApi();
        marvelApi.getCharacters(this,this);


    }

    @Override
    public void onResponseCharacters(ArrayList<Character> characterses) {

        mcharacters.addAll(characterses);
        madapter.notifyDataSetChanged();


    }

    @Override
    public void onErrorResponseCharacters(int statusCode, String message) {

    }
}
