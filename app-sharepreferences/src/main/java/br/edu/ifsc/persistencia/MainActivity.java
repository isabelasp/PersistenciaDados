package br.edu.ifsc.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText editText;
    Notas nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nota = new Notas(getApplicationContext());
        editText = findViewById(R.id.textInputLayout);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (nota.salvar(editText.getText().toString())){
            Toast.makeText(this,"Texto Salvo",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nota.recuperar()) {
            sharedPreferences.getString("nota", "");
        }else{
            Toast.makeText(getApplicationContext(),"Nota não encontrada",Toast.LENGTH_LONG).show();
        }

    }
}
