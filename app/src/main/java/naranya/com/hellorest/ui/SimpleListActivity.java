package naranya.com.hellorest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import naranya.com.hellorest.R;
import naranya.com.hellorest.adapters.CharactersAdapter;
import naranya.com.hellorest.models.Character;
import naranya.com.hellorest.network.MarvelApi;
import naranya.com.hellorest.network.MarvelApiListener;

public class SimpleListActivity extends AppCompatActivity implements MarvelApiListener {
    private ListView listView;
    private ArrayList<Character>mcharacters;
    private CharactersAdapter madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView=(ListView)findViewById(R.id.list);
        mcharacters=new ArrayList<>();
        madapter=new CharactersAdapter(mcharacters,this);
        listView.setAdapter(madapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this, "you click this hero: " + mcharacters.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        setSupportActionBar(toolbar);
        MarvelApi marvelApi=new MarvelApi();
        marvelApi.getCharacters(this,this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponseCharacters(ArrayList<Character> characterses) {
        for (Character character:characterses){
            mcharacters.add(character);
        }
        madapter.notifyDataSetChanged();
    }
    @Override
    public void onErrorResponseCharacters(int statusCode, String message) {
        //TODO:Make an alert

    }
}
