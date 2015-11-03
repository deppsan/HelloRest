package naranya.com.hellorest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import naranya.com.hellorest.R;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSimple;
    private Button btnCustom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCustom=(Button)findViewById(R.id.btnCustom);
        btnSimple=(Button)findViewById(R.id.btnSimple);
        btnCustom.setOnClickListener(this);
        btnSimple.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnCustom:
                Intent  intentCustom= new Intent(LaunchActivity.this,CustomListActivity.class);
                startActivity(intentCustom);
                break;
            case R.id.btnSimple:
                Intent intentSimple= new Intent(LaunchActivity.this,SimpleListActivity.class);
                startActivity(intentSimple);
                break;
        }

    }
}
