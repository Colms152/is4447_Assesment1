package ie.ucc.bis.is4447.mylistviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {


    ListView lvMyListView;
    String[] items, prices, descriptions;

    //TAG for log
    private static final String TAG = "***IS4447****";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        Resources res = getResources();

        lvMyListView = (ListView) findViewById(R.id.lvMyListView);

        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        Log.d(TAG,"Printing items: " + items.toString());

        ItemAdapter itemAdapter = new ItemAdapter(this, items,prices,descriptions);
        Log.d(TAG,"Printing items2: " + itemAdapter.items[1].toString());
        lvMyListView.setAdapter(itemAdapter);

        /*
        lvMyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(MainActivity.this,"Clicked at" + items[i], Toast.LENGTH_LONG).show();
            }
        });
        */


        lvMyListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent startIntent = new Intent(getApplicationContext(),DetailActivity.class);
            startIntent.putExtra("Item_Index", i);

            Log.d(TAG, "Item index:" + i);

            startActivity(startIntent);
        });


    }
}