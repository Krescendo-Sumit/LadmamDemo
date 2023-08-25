package stundet.db.demoladmam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   TextView txt;
   Button type2;
   Button type3;
   Button type4;
   EditText et_number;
   CheckBox checkBox;
   Switch switch1;
   ToggleButton tb;
   RadioGroup rbg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.textView);
        type2=findViewById(R.id.btnsave1);
        type3=findViewById(R.id.btnsave2);
        type4=findViewById(R.id.btnsave3);
        et_number=findViewById(R.id.et_number);
        checkBox=findViewById(R.id.checkBox);
        switch1=findViewById(R.id.switch1);
        tb=findViewById(R.id.toggleButton);
        rbg=findViewById(R.id.rbg);

        et_number.setText("0");
        et_number.setBackgroundColor(Color.GRAY);
        et_number.setTextColor(Color.GREEN);
      //  et_number.setPadding(10,10,10,10);
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

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                 txt.setText(""+isChecked);

            }
        });
        tb.setTextOff("De-active");
        tb.setTextOn("Active");
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                txt.setText("Toggel Button : "+b+" "+tb.getText());
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                txt.setText("Switch : "+b);
            }
        });

        rbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int selcetdRadioButtonId) {
                txt.setText(""+selcetdRadioButtonId);
                RadioButton r=findViewById(selcetdRadioButtonId);
                switch (selcetdRadioButtonId)
                {
                    case R.id.radioButton:
                           if(r.isChecked())
                               txt.setText("Male");
                        break;
                    case R.id.radioButton2:
                        if(r.isChecked())
                            txt.setText("Female");
                        break;
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