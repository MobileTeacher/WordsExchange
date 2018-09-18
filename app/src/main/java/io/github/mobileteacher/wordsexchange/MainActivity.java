package io.github.mobileteacher.wordsexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    AppDatabase database;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDatabase.getDatabase(getApplicationContext());
        textView = findViewById(R.id.wordsText);
    }


    public void addWord(View view){
        EditText wordEditText = findViewById(R.id.word_editext);
        EditText hintEditText = findViewById(R.id.hint_edittext);


        database.hiddenWordDAO().insertWord(new HiddenWord(
                                wordEditText.getText().toString(),
                                hintEditText.getText().toString(),
                                "teste",
                                2,
                                "PT-BR"
                ));

        Toast.makeText(this, "Pergunta Cadastrada", Toast.LENGTH_SHORT).show();
    }


    public void updateView(View view){
        HiddenWord[] words = database.hiddenWordDAO().getAllWords();
        String wordsText = "";
        for (int i = 0; i < words.length; i++){
            HiddenWord hiddenWord = words[i];
            wordsText += String.format("%s %s\n%d %s\n\n",
                                            hiddenWord.getClearText(),
                                            hiddenWord.getHint(),
                                            hiddenWord.getLevel(),
                                            hiddenWord.getLanguage());
        }
        textView.setText(wordsText);
    }
}
