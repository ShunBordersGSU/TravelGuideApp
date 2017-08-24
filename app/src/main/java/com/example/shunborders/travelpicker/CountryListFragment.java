package com.example.shunborders.travelpicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by shunborders on 3/16/2017.
 */

public class CountryListFragment extends Fragment {

    private CountryAdapter mAdapter;
    private RecyclerView mCountryRecyclerView;

    private View view;

    private int lastSize;
    private final int INFINITY = 9999999;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);
        mCountryRecyclerView = (RecyclerView) view.findViewById(R.id.country_recycler_view);
        mCountryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        TravelPickerLab travelPickerLab = TravelPickerLab.get(getActivity());
        List<Country> countries = travelPickerLab.getCountry();

        if (countries.size()<=5){
            lastSize = 4;
        }

        if (mAdapter == null || lastSize==4 || countries.size()>lastSize) {
            if (countries.size()>lastSize){
                lastSize = INFINITY;
            }

            mAdapter = new CountryAdapter(countries);
            mCountryRecyclerView.setAdapter(mAdapter);

        } else {
            mAdapter.setCountries(countries);
            mAdapter.notifyDataSetChanged();
        }

    }

    private class CountryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView continent;

        private ImageView flag;

        private Country mCountry;

        @Override
        public void onClick(View v) {
            Intent intent = CountryActivity.newIntent(getActivity(), mCountry.getId());
            startActivity(intent);
        }

        public void bindCountry(Country country) {
            mCountry = country;
            name.setText(mCountry.getName());
            continent.setText(mCountry.getContinent());
        }

        public CountryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            name = (TextView)itemView.findViewById(R.id.Name);
            continent = (TextView)itemView.findViewById(R.id.Continent);
            flag = (ImageView)itemView.findViewById(R.id.Flag);
        }
    }

    public class CountryAdapter extends RecyclerView.Adapter<CountryHolder> {
        public List<Country> mCountries;
        public CountryAdapter(List<Country> countries) {

            mCountries = countries;
        }

        @Override
        public CountryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            if (mCountries.size()>=5) {
                view = layoutInflater.inflate(R.layout.list_item_country, parent, false);
            }
            else
                view = layoutInflater.inflate(R.layout.country_card_view, parent, false);

            return new CountryHolder(view);
        }

        @Override
        public void onBindViewHolder(CountryHolder holder, int position) {

            Country country = mCountries.get(position);
            Context context = holder.flag.getContext();
            int id = context.getResources().getIdentifier(country.getFlag(), "drawable", context.getPackageName());
            holder.flag.setImageResource(id);
            holder.bindCountry(country);
        }
        public void setCountries(List<Country> countries) {

            mCountries = countries;
        }

        @Override
        public int getItemCount() {

            return mCountries.size();
        }
    }
}
