package software.ragp.com.projectotemporal.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class GestorDB extends SQLiteOpenHelper {
    private static GestorDB gestorDBI;
    public GestorDB(@Nullable Context context) {
        super(context, Constans.DATABASE_NAME,null,Constans.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constans.TABLE_ENCARGO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static synchronized GestorDB getInstance (Context context){
        if (gestorDBI==null){
            gestorDBI=new GestorDB(context);
        }
        return gestorDBI;
    }
}
