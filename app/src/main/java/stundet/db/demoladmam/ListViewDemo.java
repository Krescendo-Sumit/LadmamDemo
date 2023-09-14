package stundet.db.demoladmam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewDemo extends AppCompatActivity {
    String states[]={"Mahate","MahaSe","Maharashtra","Goa","Himachal Pradesh","Karnataka","Telangana","Abdhra Pradesh","Arunachal Pradesh"};
    ArrayAdapter arrayAdapter;
    Context context;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
      context=ListViewDemo.this;
          list=findViewById(R.id.list);
        arrayAdapter=new ArrayAdapter(context, android.R.layout.simple_list_item_1,states);

        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, ""+states[i], Toast.LENGTH_SHORT).show();
            }
        });


    }
}