package org.pokemon.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;

import org.pokemon.R;
import org.pokemon.entity.Pokemon;
import org.pokemon.util.SQLiteHelper;

public class HatchActivity extends Activity {
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

        pm = new Pokemon();

        TextView all = (TextView) findViewById(R.id.all);
        TextView now = (TextView) findViewById(R.id.now);
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

        //save Pokemon ability
        nextPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hp.isChecked())
                    if (atk.isChecked())
                        pm.setHp(V);
                pm.setAtk(V);
                if (def.isChecked())
                    pm.setDef(V);
                if (spAtk.isChecked())
                    pm.setSpAtk(V);
                if (spDef.isChecked())
                    pm.setSpDef(V);
                if (speed.isChecked())
                    pm.setSpeed(V);

                Toast toast = Toast.makeText(getApplicationContext(), new Gson().toJson(pm), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                sqLiteHelper.insert(pm);
            }
        });

        recall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HatchActivity.this, HatchHistory.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
//        tv.setText("Ninja comes");
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((TextView)view).setText("clicks");
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    private myOnClickListener implements View.OnClickListener(){
//        @Override
//        public void onClick(View view) {
//            Toast toast=Toast.makeText(getApplicationContext(), "show me the money", Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.show();
//        }
//    }
}

