package software.ragp.com.projectotemporal.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManagerDB {
    private static ManagerDB intanceOne;
    Context context;
    GestorDB gestorDB;
    SQLiteDatabase db;

    public ManagerDB(Context context) {
        this.context = context;
        gestorDB = GestorDB.getInstance(context);
    }

    public static synchronized ManagerDB getInstance(Context con){
        if (intanceOne==null){
            intanceOne = new ManagerDB(con);
        }
        return intanceOne;
    }

    private void openWriteDB(){
        db = gestorDB.getWritableDatabase();
    }

    private void openReadDB(){
        db = gestorDB.getReadableDatabase();
    }


    private void closeDB(){
        db.close();
    }


    public void insertEncargo(Encargo encargo){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("TIPOOBJ",encargo.getTipoObj());
        values.put("VALORD", encargo.getValorD());
        values.put("ORIGEN", encargo.getOrigen());
        values.put("DESTINO", encargo.getDestino());
        values.put("PESO", encargo.getPeso());
        values.put("LARGO", encargo.getLargo());
        values.put("ALTO", encargo.getAlto());
        values.put("ANCHO", encargo.getAncho());
        values.put("TIPORIESGO", encargo.getTipoRiesgo());
        values.put("CANTIDAD", encargo.getCantidad());
        values.put("ESCALARIESGO", encargo.getEscalaDeRiesgo());
        values.put("ESTADO", encargo.getEstado());
        values.put("OBJETOEX", encargo.getObjetoEx());
        values.put("DESCRIPCION", encargo.getDescripcion());
        values.put("FECHA",encargo.getFecCreacion());
        values.put("NOMBRE",encargo.getNombre());
        values.put("APELLIDO",encargo.getApellido());
        values.put("TELEFONO",encargo.getTelefono());
        values.put("DOCUMENTO",encargo.getDocumento());
        values.put("CORREO",encargo.getCorreo());
        values.put("DIRECCION",encargo.getDireccion());
        db.insert("ENCARGO",null,values);
        closeDB();
    }

    public void updateEncargo(Encargo encargo){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("TIPOOBJ",encargo.getTipoObj());
        values.put("VALORD", encargo.getValorD());
        values.put("ORIGEN", encargo.getOrigen());
        values.put("DESTINO", encargo.getDestino());
        values.put("LARGO", encargo.getLargo());
        values.put("ALTO", encargo.getAlto());
        values.put("ANCHO", encargo.getAncho());
        values.put("TIPORIESGO", encargo.getTipoRiesgo());
        values.put("CANTIDAD", encargo.getCantidad());
        values.put("ESCALARIESGO", encargo.getEscalaDeRiesgo());
        values.put("ESTADO", encargo.getEstado());
        values.put("OBJETOEX", encargo.getObjetoEx());
        values.put("DESCRIPCION", encargo.getDescripcion());
        values.put("FECHA",encargo.getFecCreacion());
        values.put("NOMBRE",encargo.getNombre());
        values.put("APELLIDO",encargo.getApellido());
        values.put("TELEFONO",encargo.getTelefono());
        values.put("DOCUMENTO",encargo.getDocumento());
        values.put("CORREO",encargo.getCorreo());
        values.put("DIRECCION",encargo.getDireccion());
        db.update("ENCARGO",values,"IDENCARGO="+encargo.getId(),null);
        closeDB();
    }

    public List<Encargo> selectAllEncargo(){
        List<Encargo> results = new ArrayList<>();
        openReadDB();
        Cursor cursor = db.rawQuery("SELECT * FROM ENCARGO;",null);
        if (cursor.moveToFirst()){
            do {
                Encargo encargo = new Encargo();
                encargo.setId(cursor.getInt(0));
                encargo.setTipoObj(cursor.getString(1));
                encargo.setPeso(cursor.getString(2));
                encargo.setValorD(cursor.getString(3));
                encargo.setOrigen(cursor.getString(4));
                encargo.setDestino(cursor.getString(5));
                encargo.setLargo(cursor.getString(6));
                encargo.setAlto(cursor.getString(7));
                encargo.setAncho(cursor.getString(8));
                encargo.setTipoRiesgo(cursor.getString(9));
                encargo.setCantidad(cursor.getString(10));
                encargo.setEscalaDeRiesgo(cursor.getString(11));
                encargo.setEstado(cursor.getString(12));
                encargo.setObjetoEx(cursor.getString(13));
                encargo.setDescripcion(cursor.getString(14));
                encargo.setFecCreacion(cursor.getString(15));
                encargo.setNombre(cursor.getString(16));
                encargo.setApellido(cursor.getString(17));
                encargo.setTelefono(cursor.getString(18));
                encargo.setDocumento(cursor.getString(19));
                encargo.setCorreo(cursor.getString(20));
                encargo.setDireccion(cursor.getString(21));
                results.add(encargo);

            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();

        return results;
    }

    public List<Encargo> selectOneEncargo(int id){
        List<Encargo> results = new ArrayList<>();
        openReadDB();
        Cursor cursor = db.rawQuery("SELECT * FROM ENCARGO WHERE IDENCARGO="+id+";",null);
        if (cursor.moveToFirst()){
            do {
                Encargo encargo = new Encargo();
                encargo.setId(cursor.getInt(0));
                encargo.setTipoObj(cursor.getString(1));
                encargo.setPeso(cursor.getString(2));
                encargo.setValorD(cursor.getString(3));
                encargo.setOrigen(cursor.getString(4));
                encargo.setDestino(cursor.getString(5));
                encargo.setLargo(cursor.getString(6));
                encargo.setAlto(cursor.getString(7));
                encargo.setAncho(cursor.getString(8));
                encargo.setTipoRiesgo(cursor.getString(9));
                encargo.setCantidad(cursor.getString(10));
                encargo.setEscalaDeRiesgo(cursor.getString(11));
                encargo.setEstado(cursor.getString(12));
                encargo.setObjetoEx(cursor.getString(13));
                encargo.setDescripcion(cursor.getString(14));
                encargo.setFecCreacion(cursor.getString(15));
                encargo.setNombre(cursor.getString(16));
                encargo.setApellido(cursor.getString(17));
                encargo.setTelefono(cursor.getString(18));
                encargo.setDocumento(cursor.getString(19));
                encargo.setCorreo(cursor.getString(20));
                encargo.setDireccion(cursor.getString(21));
                results.add(encargo);

            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();

        return results;
    }




}
