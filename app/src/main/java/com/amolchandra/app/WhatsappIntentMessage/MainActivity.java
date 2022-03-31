package com.amolchandra.app.WhatsappIntentMessage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.amolchandra.app.WhatsappIntentMessage.MainActivity;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {

    private Toolbar tb;
    
    private EditText intentPhoneNumber,intentMessage;
    private Button sendIntentMessage;
    
    private String txtNumber,txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListener();
    }

    private void init() {
        tb=findViewById(R.id.toolbar);
        
        intentPhoneNumber=findViewById(R.id.intentPhoneNumber);
        intentMessage=findViewById(R.id.intentMessage);
        sendIntentMessage=findViewById(R.id.sendIntentMessage);
    }

    private void initListener() {
        setSupportActionBar(tb);
        
        sendIntentMessage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    txtNumber=intentPhoneNumber.getText().toString();
                    txtMessage=intentMessage.getText().toString();
                
                    if(txtNumber.isEmpty()||txtMessage.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please enter details", Toast.LENGTH_SHORT).show();
                        return;
                     }
                     //Pre-default +91 for indians,(for other countries) change it to your country code..
                     sendIntentMessage("+91"+txtNumber,txtMessage);
                }
            });
    }
    
    private void sendIntentMessage(String phoneNumber,String message){
       Intent intent=new Intent(Intent.ACTION_VIEW);
       intent.setData(Uri.parse("https://api.whatsapp.com/send?phone="+ phoneNumber +"&text="+message));
       startActivity(intent);
       
    }
}


