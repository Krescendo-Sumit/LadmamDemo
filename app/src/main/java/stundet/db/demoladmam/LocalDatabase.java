package stundet.db.demoladmam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LocalDatabase extends AppCompatActivity {
EditText et_name,et_mobile;
Button btnsave;
MyDatabase db;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_database);
        context=LocalDatabase.this;
        db=new MyDatabase(context);
        et_name=findViewById(R.id.et_name);
                et_mobile=findViewById(R.id.et_mobile);
                btnsave=findViewById(R.id.btnsave);

                btnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=et_name.getText().toString().trim();
                        String mobile=et_mobile.getText().toString().trim();

                        if(name.equals(""))
                        {
                            et_name.setError("Please enter ");
                        }else if(mobile.equals(""))
                        {
                            et_mobile.setError("Please enter mobile number");
                        }
                        else if(mobile.length()<10|| mobile.length()>10)
                        {
                            et_mobile.setError("Invalid Number");
                        }else
                        {
                            if(db.insertUser(name,mobile))
                            {
                                Toast.makeText(context, "Data Saved Successfully.", Toast.LENGTH_SHORT).show();
                            }else
                            {
                                Toast.makeText(context, "Error in Query", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(LocalDatabase.this, "Name :"+name+"\nMobile :"+mobile, Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
}