package com.example.shunborders.travelpicker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shunborders.travelpicker.CountryDBSchema.CountryTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by shunborders on 3/16/2017.
 */

public class TravelPickerLab {

    private static TravelPickerLab sTravelPickerLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static TravelPickerLab get(Context context) {
        if (sTravelPickerLab == null) {
            sTravelPickerLab = new TravelPickerLab(context);
        }
        return sTravelPickerLab;
    }

    private TravelPickerLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CountryBaseHelper(mContext).getWritableDatabase();

        String name = "United States";
        String continent = "North America";
        String flag = "usa";
        String info = "The United States of America, commonly referred to as the United States " +
                "(U.S.) or America, is a constitutional federal republic composed of 50 states, a " +
                "federal district, five major self-governing territories, and various possessions." +
                "Forty-eight of the fifty states and the federal district are contiguous and" +
                " located in North America between Canada and Mexico. The state of Alaska is in the " +
                "northwest corner of North America, bordered by Canada to the east and across the " +
                "Bering Strait from Russia to the west. The state of Hawaii is an archipelago in " +
                "the mid-Pacific Ocean. The U.S. territories are scattered about the Pacific Ocean " +
                "and the Caribbean Sea. Nine time zones are covered. The geography, climate and " +
                "wildlife of the country are extremely diverse";
        String pic = "con_usa";

        Country country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Canada";
        continent = "North America";
        flag = "can";
        info = "Canada is a country in the northern half of " +
                "North America. Its ten provinces and three territories extend from the Atlantic to " +
                "the Pacific and northward into the Arctic Ocean, covering 9.98 million square " +
                "kilometres (3.85 million square miles), making it the world's second-largest " +
                "country by total area and the fourth-largest country by land area. Canada's border" +
                " with the United States is the world's longest binational land border. The majority" +
                " of the country has a cold or severely cold winter climate, but southerly areas are" +
                " warm in summer. Canada is sparsely populated, the majority of its land territory " +
                "being dominated by forest and tundra and the Rocky Mountains. It is highly " +
                "urbanized with 82 per cent of the 35.15 million people concentrated in large and " +
                "medium-sized cities, many near the southern border. One third of the population " +
                "lives in the three largest cities: Toronto, Montreal and Vancouver. Its capital is" +
                " Ottawa, and other major urban areas include Calgary, Edmonton, Quebec City, " +
                "Winnipeg and Hamilton.";
        pic = "con_can";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Brazil";
        continent = "South America";
        flag = "brz";
        info = "Brazil, officially the Federative Republic of Brazil (Portuguese: República " +
                "Federativa do Brasil), is the largest " +
                "country in both South America and Latin America. As the world's fifth-largest " +
                "country by both area and population, it is the largest country to have Portuguese" +
                " as an official language and the only one in the Americas.Bounded by the " +
                "Atlantic Ocean on the east, Brazil has a coastline of 7,491 kilometers (4,655 mi)" +
                "It borders all other South American countries except Ecuador and Chile and " +
                "covers 47.3% of the continent's land area.Its Amazon River basin includes a " +
                "vast tropical forest, home to diverse wildlife, a variety of ecological systems, " +
                "and extensive natural resources spanning numerous protected habitats. This " +
                "unique environmental heritage makes Brazil one of 17 megadiverse countries, and is " +
                "the subject of significant global interest and debate regarding deforestation and " +
                "environmental protection.";
        pic = "con_bra";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Colombia";
        continent = "South America";
        flag = "col";
        info = "Colombia, officially the Republic of Colombia (Spanish: República " +
                "de Colombia) is a transcontinental country largely situated " +
                "in the northwest of South America, with territories in Central America. Colombia " +
                "shares a border to the northwest with Panama, to the east with Venezuela and Brazil" +
                " and to the south with Ecuador and Peru.It shares its maritime limits with " +
                "Costa Rica, Nicaragua, Honduras, Jamaica, Haiti and the Dominican Republic. It is " +
                "a unitary, constitutional republic comprising thirty-two departments. The territory" +
                " of what is now Colombia was originally inhabited by indigenous peoples including " +
                "the Muisca, the Quimbaya and the Tairona.";
        pic = "con_col";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "France";
        continent = "Europe";
        flag = "fran";
        info = "France, officially the French Republic (République française), " +
                "is a country with territory in western Europe and several overseas regions and " +
                "territories. The European, or metropolitan, area of France extends from the " +
                "Mediterranean Sea to the English Channel and the North Sea, and from the Rhine to" +
                " the Atlantic Ocean. Overseas France include French Guiana on the South American " +
                "continent and several island territories in the Atlantic, Pacific and Indian oceans." +
                " France spans 643,801 square kilometres (248,573 sq mi) and had a total " +
                "population of almost 67 million people as of January 2017. It is a unitary " +
                "semi-presidential republic with the capital in Paris, the country's largest city " +
                "and main cultural and commercial centre. Other major urban centres include" +
                " Marseille[XVI], Lyon, Lille, Nice, Toulouse and Bordeaux.";
        pic = "con_fra";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Spain";
        continent = "Europe";
        flag = "spa";
        info = "Spain (Spanish: España), officially the Kingdom" +
                " of Spain (Spanish: Reino de España), is a sovereign state located on the " +
                "Iberian Peninsula in southwestern Europe, with two large archipelagos, the Balearic" +
                " Islands in the Mediterranean Sea and the Canary Islands off the North African " +
                "Atlantic coast, two cities Ceuta and Melilla in the North African mainland and " +
                "several small islands in the Alboran Sea near the Moroccan coast. Its mainland is " +
                "bordered to the south and east by the Mediterranean Sea except for a small land " +
                "boundary with Gibraltar; to the north and northeast by France, Andorra, and the Bay" +
                " of Biscay; and to the west and northwest by Portugal and the Atlantic Ocean. It is" +
                " the only European country to have a border with an African country (Morocco) " +
                "and its African territory accounts for nearly 5% of its population, mostly in the " +
                "Canary Islands but also in Ceuta and Melilla.";
        pic = "con_spa";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Japan";
        continent = "Asia";
        flag = "jap";
        info = "Japan (Japanese: 日本 Nippon or Nihon; formally 日本国  or Nihon-koku, means" +
                " \"State of Japan\") is a sovereign island nation in Eastern Asia. Located in the " +
                "Pacific Ocean, it lies off the eastern coast of the Asia Mainland (east of China, " +
                "Korea, Russia) and stretches from the Sea of Okhotsk in the north to the East China" +
                " Sea and Taiwan in the southwest.";
        pic = "con_jap";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "South Korea";
        continent = "Asia";
        flag = "kor";
        info = "South Korea, officially the Republic of Korea , is a sovereign state in East Asia, " +
                "constituting the southern part of the Korean Peninsula.\n" +
                "\n" +
                "Highly urbanized at 92%,South Koreans lead a distinctive urban lifestyle; half of " +
                "them live in high-rises concentrated in the Seoul Capital Area with 25 million " +
                "residents and the world's sixth leading global city with the fourth largest " +
                "economy and seventh most sustainable city in the world.";
        pic = "con_sko";

        country =
                new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Kenya";
        continent = "Africa";
        flag = "ken";
        info = "Kenya, officially the Republic of Kenya, is a country in Africa and a founding " +
                "member of the East African Community (EAC). Its capital and largest city is " +
                "Nairobi. Kenya's territory lies on the equator and overlies the East African Rift " +
                "covering a diverse and expansive terrain that extends roughly from Lake Victoria " +
                "to Lake Turkana (formerly called Lake Rudolf) and further south-east to the Indian" +
                "Ocean. It is bordered by Tanzania to the south and southwest, Uganda to the west," +
                " South Sudan to the north-west, Ethiopia to the north and Somalia to the " +
                "north-east. Kenya covers 581,309 km2 (224,445 sq mi), and had a population of " +
                "approximately 48 million people in January 2017.";
        pic = "con_ken";

        country = new Country(name,continent,flag,info,pic);

        addCountry(country);

        name = "Congo";
        continent = "Africa";
        flag = "con";
        info = "The Democratic Republic of the Congo (French: République démocratique du Congo), " +
                "also known as DR Congo, DRC, DROC, East Congo, Congo-Kinshasa, or simply the " +
                "Congo is a country located in Central Africa. From 1971 to 1997 it was named," +
                " and is sometimes still called, Zaire, and from 1908 to 1960 it was called the " +
                "Belgian Congo. The DRC borders the Central African Republic, and South Sudan to " +
                "the north; Uganda, Rwanda, Burundi and Tanzania to the east; Zambia and Angola to " +
                "the south; the Republic of the Congo to the west and the Atlantic Ocean to the " +
                "southwest. It is the second-largest country in Africa by area and eleventh largest " +
                "in the world. With a population of over 80 million, the Democratic Republic of " +
                "the Congo is the most populated officially Francophone country, the fourth " +
                "most-populated nation in Africa and the eighteenth most populated country in the " +
                "world.";
        pic = "con_con";

        country =
                new Country(name,continent,flag,info,pic);

        addCountry(country);

    }

    public void addCountry(Country c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CountryTable.NAME, null, values);
    }

    public void deleteCountry(Country c, String con) {
        ContentValues values = getContentValues(c);
        mDatabase.delete(CountryTable.NAME, c.getContinent() + "=" + con, null);
    }

    public List<Country> getCountry() {
        List<Country> countries = new ArrayList<>();
        CountryCursorWrapper cursor = queryCountries(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                countries.add(cursor.getCountry());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return countries;
    }

    public Country getCountry(UUID id) {
        CountryCursorWrapper cursor = queryCountries(
                CountryTable.Cols.UUID + " = ?", new String[] { id.toString() }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCountry();
        } finally {
            cursor.close();
        }
    }

    public void updateCountry(Country country) {
        String uuidString = country.getId().toString();
        ContentValues values = getContentValues(country);
        mDatabase.update(CountryTable.NAME, values,
                CountryTable.Cols.UUID + " = ?", new String[] { uuidString });
    }

    private static ContentValues getContentValues(Country country) {
        ContentValues values = new ContentValues();
        values.put(CountryTable.Cols.UUID, country.getId().toString());
        values.put(CountryTable.Cols.COUNTRYNAME, country.getName());
        values.put(CountryTable.Cols.CONTINENT, country.getContinent());
        values.put(CountryTable.Cols.FLAG, country.getFlag());
        values.put(CountryTable.Cols.INFO, country.getInfo());
        values.put(CountryTable.Cols.PIC, country.getPic());
        values.put(CountryTable.Cols.COMMENTS, country.getComments());
        values.put(CountryTable.Cols.RATING, country.getRating());
        return values;
    }

    private CountryCursorWrapper queryCountries(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(CountryTable.NAME, null, whereClause, whereArgs, null, null, null);
        return new CountryCursorWrapper(cursor);
    }
}
