package org.pokemon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import com.google.gson.Gson;

import org.pokemon.R;
import org.pokemon.entity.Pokemon;
import org.pokemon.util.SQLiteHelper;

public class HatchActivity extends Activity {
    private int totalNumber;
    private int currentNumber;
    private Pokemon pm;
    private final int V = 31;
    private ToggleButton hp;
    private ToggleButton atk;
    private ToggleButton def;
    private ToggleButton spAtk;
    private ToggleButton spDef;
    private ToggleButton speed;
    private Button nextPM;
    private Button recall;
    private TextView total;
    private TextView current;

    private SQLiteHelper sqLiteHelper;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(pm == null)
             pm = new Pokemon();

        total = (TextView) findViewById(R.id.total);
        current = (TextView) findViewById(R.id.current);
        hp = (ToggleButton) findViewById(R.id.hp);
        atk = (ToggleButton) findViewById(R.id.atk);
        def = (ToggleButton) findViewById(R.id.def);
        spAtk = (ToggleButton) findViewById(R.id.spAtk);
        spDef = (ToggleButton) findViewById(R.id.spDef);
        speed = (ToggleButton) findViewById(R.id.speed);
        nextPM = (Button) findViewById(R.id.next);
        recall = (Button) findViewById(R.id.recall);
        sqLiteHelper = new SQLiteHelper(getApplicationContext());
        Gson gson = new Gson();
        totalNumber = sqLiteHelper.getCount();
        setTotalNumber(totalNumber);
        //save Pokemon ability
        nextPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hp.isChecked())
                    pm.setHp(V);
                else
                    pm.setHp(0);
                if (atk.isChecked())
                    pm.setAtk(V);
                else
                    pm.setAtk(0);
                if (def.isChecked())
                    pm.setDef(V);
                else
                    pm.setDef(0);
                if (spAtk.isChecked())
                    pm.setSpAtk(V);
                else
                    pm.setSpAtk(0);
                if (spDef.isChecked())
                    pm.setSpDef(V);
                else
                    pm.setSpDef(0);
                if (speed.isChecked())
                    pm.setSpeed(V);
                else
                    pm.setSpeed(0);

                setPokemonGastly(pm);
                Toast toast = Toast.makeText(getApplicationContext(), new Gson().toJson(pm), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                sqLiteHelper.insert(pm);

                setTotalNumber(++totalNumber);
                setCurrentNumber(++currentNumber);
            }
        });

        recall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HatchActivity.this, HatchHistory.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                currentNumber=0;
                setCurrentNumber(0);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private void setTotalNumber(int totalNumber) {
        total.setText("总计：" + totalNumber + "个");
    }

    private void setCurrentNumber(int currentNumber) {
        current.setText("本轮：" + currentNumber + "个");
    }


    public void setPokemon(Pokemon pokemon){

        this.pm = pokemon;
    }


    /**
     * 袋龙 115 female
     * 百变怪 132 netral
     * gastly 92 all
     */
    public void setPokemonGastly(Pokemon pm){
        pm.setPokemonIndex(92);
        pm.setGender("netral");
        pm.setName("gastly");
    }


}

