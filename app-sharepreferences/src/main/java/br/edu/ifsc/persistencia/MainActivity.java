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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("dadosUsuario",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editText = findViewById(R.id.textInputLayout);

    }

    @Override
    protected void onPause() {
        super.onPause();
        editor.putString("nota", editText.getText().toString());
        editor.commit();
        Toast.makeText(this,"Texto Salvo",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPreferences.contains("nota"))
            sharedPreferences.getString("nota","");
        else
            Toast.makeText(getApplicationContext(),"Nota não encontrada",Toast.LENGTH_LONG).show();;
    }
}
