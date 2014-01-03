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

    ArrayList<Pokemon> pokemonList;
    Context context;

    public PokemonListAdapter(Context ctx, ArrayList<Pokemon> pmList) {
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
        TextView tvid = (TextView) convertView.findViewById(R.id.tvid);
        tvid.setText(String.valueOf(pm.getId()));
        TextView tvname = (TextView) convertView.findViewById(R.id.tvname);
        tvname.setText(String.valueOf(pm.getName()));
        TextView tvhp = (TextView) convertView.findViewById(R.id.tvhp);
        tvhp.setText(String.valueOf(pm.getHp()));
        TextView tvAtk = (TextView) convertView.findViewById(R.id.tvatk);
        tvAtk.setText(String.valueOf(pm.getAtk()));
        TextView tvDef = (TextView) convertView.findViewById(R.id.tvdef);
        tvDef.setText(String.valueOf(pm.getDef()));
        TextView tvspatk = (TextView) convertView.findViewById(R.id.tvspatk);
        tvspatk.setText(String.valueOf(pm.getSpAtk()));
        TextView tvspdef = (TextView) convertView.findViewById(R.id.tvspdef);
        tvspdef.setText(String.valueOf(pm.getSpDef()));
        TextView tvspeed = (TextView) convertView.findViewById(R.id.tvspeed);
        tvspeed.setText(String.valueOf(pm.getSpeed()));

//        convertView.setTag();
        return convertView;
    }
}
