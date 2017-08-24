package com.example.shunborders.travelpicker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CountryActivity extends SingleFragmentActivity {

    public static final String EXTRA_TRAVEL_PICKER_ID =
            "com.example.shunborders.travelpicker.country_id";

    public static Intent newIntent(Context packageContext, UUID countryId) {
        Intent intent = new Intent(packageContext, CountryActivity.class);
        intent.putExtra(EXTRA_TRAVEL_PICKER_ID, countryId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID countryId = (UUID) getIntent().getSerializableExtra(EXTRA_TRAVEL_PICKER_ID);
        return CountryFragment.newInstance(countryId);
    }
}
