package com.example.shunborders.travelpicker;

import android.support.v4.app.Fragment;

/**
 * Created by shunborders on 3/16/2017.
 */

public class CountryListActivity extends SingleFragmentActivity {

    @Override

    protected Fragment createFragment() {

        return new CountryListFragment();
    }
}
