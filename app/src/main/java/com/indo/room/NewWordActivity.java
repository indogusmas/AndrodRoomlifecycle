package com.indo.room;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLAY= "replay";
    private EditText mEditWordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.recyclerview);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replayIntent = new Intent();
                if (!TextUtils.isEmpty(mEditWordView.getText().toString())){
                    setResult(RESULT_CANCELED, replayIntent);
                }else {
                    String word = mEditWordView.getText().toString();
                    replayIntent.putExtra(EXTRA_REPLAY, word);
                    setResult(RESULT_OK, replayIntent);
                }
                finish();
            }
        });
    }
}
