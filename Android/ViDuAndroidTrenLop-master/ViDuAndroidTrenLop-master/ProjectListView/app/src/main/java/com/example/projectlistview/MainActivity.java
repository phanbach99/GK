package com.example.projectlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
   // String[] presidents = {"Dwight D. Eisenhover</item> "John F.Kennedy</item> "Lydon B . John son</item> "Richard Nixon</item> "Gerald Ford</item> "Jummy Carter</item> "Ronald Reagan</item> "Bill Clinton</item> "George W. Bush</item> "Barack Obama"};
String[] presidents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //ListView lst=getListView();
   // lst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
   // lst.setTextFilterEnabled(true);
    presidents=getResources().getStringArray(R.array.president_array);
    setListAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, presidents));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Toast.makeText(this,"You have selected "+presidents[position],Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view){
        ListView lst= getListView();
        String itemSelected="Selected Item: \n";
        for (int i=0;i<lst.getCount();i++)
            itemSelected+=lst.getItemAtPosition(i)+"\n";

        Toast.makeText(this,itemSelected,Toast.LENGTH_SHORT).show();
    }

}

