package stundet.db.demoladmam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerDemo extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String states[]={"Mahate","MahaSe","Maharashtra","Goa","Himachal Pradesh","Karnataka","Telangana","Abdhra Pradesh","Arunachal Pradesh"};
    ArrayAdapter arrayAdapter;
    Context context;

    Spinner spinner;
    ArrayAdapter arrayAdapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        context=SpinnerDemo.this;
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        spinner=findViewById(R.id.spinner);
        autoCompleteTextView.setThreshold(3);
        arrayAdapter=new ArrayAdapter(context, android.R.layout.simple_list_item_1,states);
        arrayAdapterSpinner=new ArrayAdapter(context, android.R.layout.simple_list_item_1,states);
        autoCompleteTextView.setAdapter(arrayAdapter);
        spinner.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(context, "i="+i+" l="+l, Toast.LENGTH_SHORT).show();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(context, str+" Selected - "+states[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(context, "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });



    }
}