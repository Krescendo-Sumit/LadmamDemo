package stundet.db.demoladmam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   TextView txt;
   Button type2;
   Button type3;
   Button type4;
   EditText et_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.textView);
        type2=findViewById(R.id.btnsave1);
        type3=findViewById(R.id.btnsave2);
        type4=findViewById(R.id.btnsave3);
        et_number=findViewById(R.id.et_number);
        type3.setOnClickListener(this);
        type4.setOnClickListener(this);

        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String number=et_number.getText().toString().trim();
               if(number.equals(""))
               {
                   et_number.setError("Invalid Number");
                   return;
               }
               else {
                   int n=Integer.parseInt(number);
                   txt.setText("seperate for button clicked "+ (n*n));
               }
            }
        });

    }
    public void show(View v)
    {
         txt.setText("Button Clicked");
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btnsave2:
                txt.setText("Implemtns Listener 1");
                break;
            case R.id.btnsave3:
                txt.setText("Implemtns Listener 2");
                break;
        }



    }
}