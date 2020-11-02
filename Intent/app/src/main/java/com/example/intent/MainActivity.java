package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button btn=findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                EditText url=findViewById(R.id.editText);
                String link=url.getText().toString();
                if (!link.startsWith("https://"))
                {
                    link = "https://" + link;
                }
                Uri uri= Uri.parse(link);
                intent.setData(uri);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}