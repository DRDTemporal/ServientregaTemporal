package software.ragp.com.projectotemporal.models;

import android.content.Context;

public class ManagerDB {
    private static ManagerDB intanceOne;
    Context context;
    GestorDB gestorDB;

    public ManagerDB(Context context) {
        this.context = context;
    }

    public static synchronized ManagerDB getInstance(Context con){
        if (intanceOne==null){
            intanceOne = new ManagerDB(con);
        }
        return intanceOne;
    }

    public void insertEncargo(){

    }
}
