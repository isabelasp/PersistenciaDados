package br.edu.ifsc.persistencia;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;

public class Notas {
    Context context;
    SQLiteDatabase db;
    public static final String SqliteDataBase = "database";
    public static final String Nota = "nota";

    public Notas(Context c){
        context = c;
        db = context.openOrCreateDatabase(SqliteDataBase,context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE notas (id INTEGER primary key AUTOINCREMENT, nota varchar(255))");
    }

    public Boolean salvar(String texto){
        return true;

        /*if (editor.commit()) {
            return true;
        }else{
            return false;
        }*/
    }

    public String recuperar(){
            return "";

    }
}
