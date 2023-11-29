package com.gulshan.healthbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername=findViewById(R.id.editTextLTBFullName);
        edEmail=findViewById(R.id.editTextLTBAddress);
        edPassword=findViewById(R.id.editTextLTBPincode);
        edConfirm=findViewById(R.id.editTextLTBContactNumber);
        btn=findViewById(R.id.buttonLTBBooking);
        tv=findViewById(R.id.textViewExistingUser);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();
                String confirm=edConfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || email.length()==0 || password.length()==0 || confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please Fill all details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.compareTo(confirm)==0)
                    {
                        if(isValid(password))
                        {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Registered Successfully!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Password must contain at least 8 characters,having letter,digit and special symbol",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Password and Confirm Password didn't match",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });




    }
    public static boolean isValid(String password)
    {
        int f1=0,f2=0,f3=0;
        if(password.length()<8)
            return false;
        else
        {
            for(int i=0;i<password.length();i++)
            {
                if(Character.isLetter(password.charAt(i))) {
                    f1 = 1;
                }
            }
            for(int i=0;i<password.length();i++)
            {
                if(Character.isDigit(password.charAt(i))) {
                    f2 = 1;
                }
            }
            for(int i=0;i<password.length();i++)
            {
                char ch=password.charAt(i);
                if(ch>=33 && ch<=46 || ch==64)
                    f3=1;
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}
