package br.edu.ifsc.persistencia;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class Notas {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public Notas(Context c){
        context = c;
        sharedPreferences = context.getSharedPreferences("notas", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public Boolean salvar(String texto){
        editor.putString("nota", texto);
        if (editor.commit()) {
            return true;
        }else{
            return false;
        }
    }

    public String recuperar(){
        if(sharedPreferences.contains("nota")) {
            return sharedPreferences.getString("nota","");
        }else {
            return "Nota não recuperada";
        }
    }
}
