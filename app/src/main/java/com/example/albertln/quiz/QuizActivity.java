package com.example.albertln.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private PreguntaTest pregunta;
    private RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String[] respostes = new String[4];
        respostes[0] = "Barcelona";
        respostes[1] = "Londres";
        respostes[2] = "Paris";
        respostes[3] = "Hanoi";

        pregunta = new PreguntaTest(
                "Quina és la capital del Vietnam?", respostes, 3
        );

        TextView textview = findViewById(R.id.textview);
        radiogroup = findViewById(R.id.respostesview);
        RadioButton btn_resposta0 = findViewById(R.id.btn_resposta0);
        RadioButton btn_resposta1 = findViewById(R.id.btn_resposta1);
        RadioButton btn_resposta2 = findViewById(R.id.btn_resposta2);
        RadioButton btn_resposta3 = findViewById(R.id.btn_resposta3);

        textview.setText(pregunta.getText());
        btn_resposta0.setText(pregunta.getRespostes()[0]);
        btn_resposta1.setText(pregunta.getRespostes()[1]);
        btn_resposta2.setText(pregunta.getRespostes()[2]);
        btn_resposta3.setText(pregunta.getRespostes()[3]);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_comprova:

                comprovaResposta();
                break;

            case R.id.menu_reset:

                radiogroup.clearCheck();
                 break;

        }

        return true;
    }

    private void comprovaResposta() {

        if (getButtonIndex() == pregunta.getCorrecta())
        {
            Toast.makeText(this, "Molt bé!!1", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Noooo!!1", Toast.LENGTH_SHORT).show();
        }
    }

    private int getButtonIndex() {
        int index = -1;
        int selected = radiogroup.getCheckedRadioButtonId();
        int ids[] = {R.id.btn_resposta0, R.id.btn_resposta1, R.id.btn_resposta2, R.id.btn_resposta3};

        for (int i = 0; i < ids.length; i++)
        {
            if (ids[i] == selected)
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
