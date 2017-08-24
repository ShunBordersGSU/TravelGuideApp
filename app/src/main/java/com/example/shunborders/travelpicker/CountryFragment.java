package com.example.shunborders.travelpicker;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

import java.util.UUID;

import com.example.shunborders.travelpicker.CountryDBSchema;

import static com.example.shunborders.travelpicker.R.id.continent;
import static com.example.shunborders.travelpicker.R.id.pic;

/**
 * Created by shunborders on 3/16/2017.
 */

public class CountryFragment extends Fragment {

    private static final String ARG_COUNTRY_ID = "country_id";

    private SQLiteDatabase mDatabase;

    private Context mContext;
    private Country mCountry;

    private TextView NAME;
    private TextView CONTINENT;
    private TextView INFO;

    private EditText COMMENTS;

    private ImageView PIC;

    private Button yes, no;

    private RatingBar ratingBar;

    String countryName, countryContinent, countryFlag, countryInfo, countryPic;
    Country country;
    ContentValues values;


    public static CountryFragment newInstance(UUID countryId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COUNTRY_ID, countryId);
        CountryFragment fragment = new CountryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID countryId = (UUID) getArguments().getSerializable(ARG_COUNTRY_ID);
        mCountry = TravelPickerLab.get(getActivity()).getCountry(countryId);
    }

    @Override
    public void onPause() {
        super.onPause();
        TravelPickerLab.get(getActivity())
                .updateCountry(mCountry);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_country, container, false);
        NAME = (TextView) v.findViewById(R.id.Name);
        CONTINENT = (TextView) v.findViewById(continent);
        PIC = (ImageView) v.findViewById(pic);
        INFO = (TextView) v.findViewById(R.id.info);
        COMMENTS = (EditText) v.findViewById(R.id.comments);

        yes = (Button) v.findViewById(R.id.yes);
        no = (Button) v.findViewById(R.id.no);

        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        ratingBar.setRating(Float.valueOf(mCountry.getRating()));
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mCountry.setRating(String.valueOf(ratingBar.getRating()));
            }
        });


        mContext = getActivity();;
        mDatabase = new CountryBaseHelper(mContext).getWritableDatabase();

        yes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mCountry.getContinent().equals("North America")) {
                    countryName = "Mexico";
                    countryContinent = "North America";
                    countryFlag = "mex";
                    countryInfo = "Mexico (Spanish: México), officially the United Mexican States " +
                            "(Spanish: Estados Unidos Mexicanos), is a federal republic in the " +
                            "southern half of North America. It is bordered to the north by the " +
                            "United States; to the south and west by the Pacific Ocean; to the " +
                            "southeast by Guatemala, Belize, and the Caribbean Sea; and to the " +
                            "east by the Gulf of Mexico. Covering almost two million square " +
                            "kilometers (over 760,000 sq mi), Mexico is the sixth largest " +
                            "country in the Americas by total area and the 13th largest independent" +
                            "nation in the world. With an estimated population of over 120 " +
                            "million, it is the eleventh most populous country and the most " +
                            "populous Spanish-speaking country in the world while being the second" +
                            " most populous country in Latin America. Mexico is a federation " +
                            "comprising 31 states and a federal district that is also its capital" +
                            " and most populous city. Other metropolises include Guadalajara, " +
                            "Monterrey, Puebla, Toluca, Tijuana and León.";
                    countryPic = "con_mex";

                    Country country = new Country(countryName, countryContinent, countryFlag, countryInfo, countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Haiti";
                    countryContinent = "North America";
                    countryFlag = "hat";
                    countryInfo = "Haiti (French: Haïti), officially the Republic of Haiti " +
                            "(French: République d'Haïti; Haitian Creole: Repiblik Ayiti)" +
                            " and formerly called Hayti, is a country located on the island" +
                            " of Hispaniola in the Greater Antilles archipelago of the Caribbean " +
                            "Sea. It occupies the western three-eighths of the island, which it " +
                            "shares with the Dominican Republic. Haiti is 27,750 square " +
                            "kilometres (10,714 sq mi) in size and has an estimated 10.6 million " +
                            "people, making it the most populous country in the Caribbean " +
                            "Community (CARICOM) and the second-most populous country in the " +
                            "Caribbean as a whole.";
                    countryPic = "con_hat";

                    country = new Country(countryName, countryContinent, countryFlag, countryInfo, countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Cuba";
                    countryContinent = "North America";
                    countryFlag = "cub";
                    countryInfo = "Cuba, officially the Republic of Cuba (Spanish: " +
                            " República de Cuba), is a country comprising the island of Cuba as" +
                            " well as Isla de la Juventud and several minor archipelagos. Cuba is " +
                            "located in the northern Caribbean where the Caribbean Sea, the Gulf of " +
                            "Mexico, and the Atlantic Ocean meet. It is south of both the U.S. " +
                            "state of Florida and the Bahamas, west of Haiti, and north of Jamaica. " +
                            "Havana is the largest city and capital; other major cities include " +
                            "Santiago de Cuba and Camagüey. Cuba is the largest island in the " +
                            "Caribbean, with an area of 109,884 square kilometres (42,426 sq mi), " +
                            "and the second-most populous after Hispaniola, with over 11 million " +
                            "inhabitants.";
                    countryPic = "con_cub";

                    country = new Country(countryName, countryContinent, countryFlag, countryInfo, countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                }
                else if(mCountry.getContinent().equals("Europe")){

                    countryName = "Germany";
                    countryContinent = "Europe";
                    countryFlag = "ger";
                    countryInfo = "Germany (German: Deutschland), officially the Federal Republic of" +
                            " Germany (German: Bundesrepublik Deutschland), is a federal " +
                            "parliamentary republic in central-western Europe. It includes 16 " +
                            "constituent states, covers an area of 357,021 square kilometres " +
                            "(137,847 sq mi), and has a largely temperate seasonal climate. With " +
                            "about 82 million inhabitants, Germany is the most populous member " +
                            "state of the European Union. After the United States, it is the second " +
                            "most popular immigration destination in the world. Germany's " +
                            "capital and largest metropolis is Berlin, while its largest " +
                            "conurbation is the Ruhr (main centres: Dortmund and Essen). Other " +
                            "major cities include Hamburg, Munich, Cologne, Frankfurt, Stuttgart, " +
                            "Düsseldorf and Leipzig.";
                    countryPic = "con_ger";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "United Kingdom";
                    countryContinent = "Europe";
                    countryFlag = "uk";
                    countryInfo = "The United Kingdom of Great Britain and Northern Ireland, " +
                            "commonly known as the United Kingdom (UK) or Britain, is a " +
                            "sovereign country in western Europe. Lying off the north-western " +
                            "coast of the European mainland, it includes the island of Great" +
                            " Britain, the north-eastern part of the island of Ireland, and many " +
                            "smaller islands. Northern Ireland is the only part of the UK that" +
                            " shares a land border with another sovereign state, the " +
                            "Republic of Ireland. Apart from this land border, the UK is " +
                            "surrounded by the Atlantic Ocean, with the North Sea to its east, " +
                            "the English Channel to its south and the Celtic Sea to its " +
                            "south-south-west, giving it the 12th-longest coastline in the world. " +
                            "The Irish Sea lies between Great Britain and Ireland. With an area of " +
                            "242,500 square kilometres (93,600 sq mi), the UK is the 78th-largest " +
                            "sovereign state in the world and the 11th-largest in Europe. It is " +
                            "also the 21st-most populous country, with an estimated 65.1 million " +
                            "inhabitants. Together, this makes it the fourth-most densely " +
                            "populated country in the European Union.";
                    countryPic = "con_uk";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Portugal";
                    countryName = "Europe";
                    countryFlag = "por";
                    countryInfo = "Portugal, officially the Portuguese " +
                            "Republic, is a country on the Iberian Peninsula in Southwestern " +
                            "Europe. It is the westernmost country of mainland Europe. " +
                            "To the west and south it is bordered by the Atlantic Ocean " +
                            "and to the east and north by Spain. The Portugal–Spain border " +
                            "is 1,214 kilometres (754 miles) long and considered the longest " +
                            "uninterrupted border within the European Union. The republic also " +
                            "includes the Atlantic archipelagos of the Azores and Madeira, both " +
                            "autonomous regions with their own regional governments.";
                    countryPic = "con_por";

                    country = new Country(countryName,countryName,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);
                }
                else if(mCountry.getContinent().equals("South America")){
                    countryName = "Chile";
                    countryContinent = "South America";
                    countryFlag = "chl";
                    countryInfo = "Chile, officially the Republic " +
                            "of Chile, is a South American country occupying a long, narrow strip of land " +
                            "between the Andes to the east and the Pacific Ocean to the west. It " +
                            "borders Peru to the north, Bolivia to the northeast, Argentina to the " +
                            "east, and the Drake Passage in the far south. Chilean territory " +
                            "includes the Pacific islands of Juan Fernández, Salas y Gómez, " +
                            "Desventuradas, and Easter Island in Oceania. Chile also claims " +
                            "about 1,250,000 square kilometres (480,000 sq mi) of Antarctica, " +
                            "although all claims are suspended under the Antarctic Treaty.";
                    countryPic = "con_chil";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Argentina";
                    countryContinent = "South America";
                    countryFlag = "arg";
                    countryInfo = "Argentina, officially the Argentine Republic, is a federal " +
                            "republic in the southern half of South America. Sharing the bulk of " +
                            "the Southern Cone with its neighbor Chile to the west, the country is " +
                            "also bordered by Bolivia and Paraguay to the north, Brazil to the " +
                            "northeast, Uruguay and the South Atlantic Ocean to the east, and the " +
                            "Drake Passage to the south. With a mainland area of 2,780,400 km2 " +
                            "(1,073,500 sq mi), Argentina is the eighth-largest country in the " +
                            "world, the second largest in Latin America, and the largest " +
                            "Spanish-speaking one. The country is subdivided into twenty-three " +
                            "provinces (Spanish: provincias, singular provincia) and one autonomous " +
                            "city (ciudad autónoma), Buenos Aires, which is the federal capital of " +
                            "the nation (Spanish: Capital Federal) as decided by Congress. The" +
                            " provinces and the capital have their own constitutions, but exist " +
                            "under a federal system.";
                    countryPic = "con_arg";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Peru";
                    countryContinent = "South America";
                    countryFlag = "per";
                    countryInfo = "Peru, officially the Republic of Peru (Spanish: República del " +
                            "Perú), is a country in western South America. It is bordered in the " +
                            "north by Ecuador and Colombia, in the east by Brazil, in the southeast" +
                            " by Bolivia, in the south by Chile, and in the west by the Pacific" +
                            " Ocean. Peru is an extremely biodiverse country with habitats ranging" +
                            " from the arid plains of the Pacific coastal region in the west to the" +
                            " peaks of the Andes mountains vertically extending from the north to" +
                            " the southeast of the country to the tropical Amazon Basin rainforest" +
                            " in the east with the Amazon river.";
                    countryPic = "con_per";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                }
                else if(mCountry.getContinent().equals("Asia")){
                    countryName = "China";
                    countryContinent = "Asia";
                    countryFlag = "chi";
                    countryInfo = "China, officially the People's Republic of China (PRC), is a " +
                            "unitary sovereign state in East Asia. With a population of over 1.381" +
                            " billion, it is the world's most populous country. The state is" +
                            " governed by the Communist Party of China, and its capital is Beijing." +
                            " It exercises jurisdiction over 22 provinces, five autonomous regions," +
                            " four direct-controlled municipalities (Beijing, Tianjin, Shanghai, " +
                            "and Chongqing), and two mostly self-governing special administrative" +
                            " regions (Hong Kong and Macau), and claims sovereignty over Taiwan. " +
                            "The country's major urban areas include Shanghai, Guangzhou, Beijing, " +
                            "Chongqing, Shenzhen, Tianjin and Hong Kong. China is a great power " +
                            "and a major regional power within Asia, and has been characterized" +
                            " as a potential superpower.";
                    countryPic = "con_chi";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Vietnam";
                    countryContinent = "Asia";
                    countryFlag = "viet";
                    countryInfo = "Vietnam, officially the Socialist Republic of Vietnam " +
                            ", is the easternmost country on the" +
                            " Indochina Peninsula in Southeast Asia. With an estimated 92.7" +
                            " million inhabitants as of 2016, it is the world's 14th-most-populous" +
                            " country, and the ninth-most-populous Asian country. Vietnam is " +
                            "bordered by China to the north, Laos to the northwest, Cambodia to" +
                            " the southwest, Thailand across the Gulf of Thailand to the southwest," +
                            " and the Philippines, Malaysia and Indonesia across the South China " +
                            "Sea to the east and southeast. Its capital city has been Hanoi since" +
                            " the reunification of North and South Vietnam in 1976.";
                    countryPic = "con_viet";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "India";
                    countryContinent = "Asia";
                    countryFlag = "ind";
                    countryInfo = "India, officially the Republic of India (Bhārat Gaṇarājya), " +
                            "is a country in South Asia. It is the seventh-largest country by area," +
                            " the second-most populous country (with over 1.2 billion people)," +
                            " and the most populous democracy in the world. It is bounded by the" +
                            " Indian Ocean on the south, the Arabian Sea on the southwest, and the" +
                            " Bay of Bengal on the southeast. It shares land borders with Pakistan" +
                            " to the west; China, Nepal, and Bhutan to the northeast; and Myanmar" +
                            " (Burma) and Bangladesh to the east. In the Indian Ocean, India is in" +
                            " the vicinity of Sri Lanka and the Maldives. India's Andaman and" +
                            " Nicobar Islands share a maritime border with Thailand and Indonesia.";
                    countryPic = "con_ind";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);
                }
                else if(mCountry.getContinent().equals("Africa")){

                    countryName = "Algeria";
                    countryContinent = "Africa";
                    countryFlag = "alg";
                    countryInfo = "Algeria (Arabic: الجزائر; al-Jazā'ir; Berber: ⴷⵣⴰⵢⴻⵔ, Dzayer; " +
                            "French: Algérie), officially the People's Democratic Republic of " +
                            "Algeria, is a sovereign state in North Africa on the Mediterranean " +
                            "coast. Its capital and most populous city is Algiers, located in the " +
                            "country's far north. With an area of 2,381,741 square kilometres " +
                            "(919,595 sq mi), Algeria is the tenth-largest country in the world," +
                            " and the largest in Africa. Algeria is bordered to the northeast" +
                            " by Tunisia, to the east by Libya, to the west by Morocco, to the" +
                            " southwest by the Western Saharan territory, Mauritania, and Mali," +
                            " to the southeast by Niger, and to the north by the Mediterranean" +
                            " Sea. The country is a semi-presidential republic consisting of 48" +
                            " provinces and 1,541 communes (counties). Abdelaziz Bouteflika has" +
                            " been President since 1999.";
                    countryPic = "con_alg";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Angola";
                    countryContinent = "Africa";
                    countryFlag = "ang";
                    countryInfo = "Angola, officially the Republic of Angola" +
                            " (Portuguese: República de Angola; Kikongo, Kimbundu and Umbundu: " +
                            "Repubilika ya Ngola), is a country in Southern Africa. It is " +
                            "the seventh-largest country in Africa and is bordered by Namibia to" +
                            " the south, the Democratic Republic of the Congo to the north," +
                            " Zambia to the east, and the Atlantic Ocean to west. The exclave" +
                            " province of Cabinda has borders with the Republic of the Congo and" +
                            " the Democratic Republic of the Congo. The capital and largest city" +
                            " of Angola is Luanda.";
                    countryPic = "con_ang";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);

                    countryName = "Botswana";
                    countryContinent = "Africa";
                    countryFlag = "bot";
                    countryInfo = "Botswana, officially the Republic of Botswana " +
                            "(Tswana: Lefatshe la Botswana), is a landlocked country located" +
                            " in Southern Africa. The citizens refer to themselves as Batswana " +
                            "(singular: Motswana).[6][not in citation given] Formerly the British" +
                            " protectorate of Bechuanaland, Botswana adopted its new name after" +
                            " becoming independent within the Commonwealth on 30 September 1966." +
                            " Since then, it has maintained a strong tradition of stable " +
                            "representative democracy, with a consistent record of uninterrupted" +
                            " democratic elections";
                    countryPic = "con_bot";

                    country = new Country(countryName,countryContinent,countryFlag,countryInfo,countryPic);

                    values = getContentValues(country);
                    mDatabase.insert(CountryDBSchema.CountryTable.NAME, null, values);
                }
            }
        });


        NAME.setText(mCountry.getName());
        CONTINENT.setText(mCountry.getContinent());
        Context context = PIC.getContext();
        int id = context.getResources().getIdentifier(mCountry.getPic(), "drawable", context.getPackageName());
        PIC.setImageResource(id);
        INFO.setText(mCountry.getInfo());

        String comments = mCountry.getComments();
        if (comments !=null){
            COMMENTS.setText(comments);
        }
        else {
            COMMENTS.setText("Add Notes Here");
        }

        COMMENTS.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCountry.setComments(s.toString());
                String uuidString = mCountry.getId().toString();
                ContentValues values = getContentValues(mCountry);
                mDatabase.update(CountryDBSchema.CountryTable.NAME, values, CountryDBSchema.CountryTable.Cols.UUID + " = ?", new String[] { uuidString });


            }
        });

        no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    mDatabase.delete(CountryDBSchema.CountryTable.NAME,"continent=? ",new String[]{mCountry.getContinent()});


            }
        });

        return v;
    }

    private static ContentValues getContentValues(Country mCountry) {
        ContentValues values = new ContentValues();
        values.put(CountryDBSchema.CountryTable.Cols.UUID, mCountry.getId().toString());
        values.put(CountryDBSchema.CountryTable.Cols.COUNTRYNAME, mCountry.getName());
        values.put(CountryDBSchema.CountryTable.Cols.CONTINENT, mCountry.getContinent());
        values.put(CountryDBSchema.CountryTable.Cols.FLAG, mCountry.getFlag());
        values.put(CountryDBSchema.CountryTable.Cols.INFO, mCountry.getInfo());
        values.put(CountryDBSchema.CountryTable.Cols.PIC, mCountry.getPic());
        values.put(CountryDBSchema.CountryTable.Cols.COMMENTS, mCountry.getComments());
        values.put(CountryDBSchema.CountryTable.Cols.RATING, mCountry.getRating());
        return values;
    }
}
