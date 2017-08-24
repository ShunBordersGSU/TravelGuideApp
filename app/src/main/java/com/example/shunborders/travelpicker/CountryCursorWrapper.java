package com.example.shunborders.travelpicker;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.shunborders.travelpicker.CountryDBSchema.CountryTable;

import java.util.UUID;

/**
 * Created by shunborders on 3/4/2017.
 */

public class CountryCursorWrapper extends CursorWrapper {

    public CountryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Country getCountry() {

        String uuidString = getString(getColumnIndex(CountryTable.Cols.UUID));
        String name = getString(getColumnIndex(CountryTable.Cols.COUNTRYNAME));
        String continent = getString(getColumnIndex(CountryTable.Cols.CONTINENT));
        String flag = getString(getColumnIndex(CountryTable.Cols.FLAG));
        String info = getString(getColumnIndex(CountryTable.Cols.INFO));
        String pic = getString(getColumnIndex(CountryTable.Cols.PIC));
        String comments = getString(getColumnIndex(CountryTable.Cols.COMMENTS));
        String rating = getString(getColumnIndex(CountryTable.Cols.RATING));

        Country country = new Country(UUID.fromString(uuidString));
        country.setName(name);
        country.setContinent(continent);
        country.setFlag(flag);
        country.setInfo(info);
        country.setPic(pic);
        country.setComments(comments);
        country.setRating(rating);

        return country;
    }
}
