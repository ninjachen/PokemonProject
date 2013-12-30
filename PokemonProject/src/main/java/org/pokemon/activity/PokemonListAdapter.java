package org.pokemon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.pokemon.R;
import org.pokemon.entity.Pokemon;
import java.util.ArrayList;

/**
 * Created by ninja_chen on 13-12-30.
 */
public class PokemonListAdapter extends BaseAdapter {

    private ArrayList<Pokemon> pokemonList ;
    Context context;

    public PokemonListAdapter(Context ctx, ArrayList<Pokemon> pmList){
        this.context = ctx;
        this.pokemonList = pmList;
    }
    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon pm = pokemonList.get(position);

        if (convertView == null) {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pokemon_list_row, null);

        }
        TextView tvhp = (TextView) convertView.findViewById(R.id.tvhp);
        tvhp.setText(pm.getHp());
        TextView tvAtk = (TextView) convertView.findViewById(R.id.tvatk);
        tvAtk.setText(pm.getAtk());
        TextView tvDef = (TextView) convertView.findViewById(R.id.tvdef);
        tvDef.setText(pm.getDef());
        TextView tvspatk = (TextView) convertView.findViewById(R.id.tvspatk);
        tvAtk.setText(pm.getSpAtk());
        TextView tvspdef = (TextView) convertView.findViewById(R.id.tvspdef);
        tvDef.setText(pm.getSpDef());
        TextView tvspeed = (TextView) convertView.findViewById(R.id.tvspeed);
        tvDef.setText(pm.getSpeed());


        return convertView;
    }
}
