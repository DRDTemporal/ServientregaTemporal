package software.ragp.com.projectotemporal.models;

public class Constans {
    public static final String DATABASE_NAME="datos.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_ENCARGO="CREATE TABLE ENCARGO(IDENCARGO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "TIPOOBJ TEXT, PESO TEXT, VALORD TEXT, ORIGEN TEXT, DESTINO TEXT, LARGO TEXT, ALTO TEXT, " +
            "ANCHO TEXT, TIPORIESGO TEXT, CANTIDAD TEXT, ESCALARIESGO TEXT, ESTADO TEXT, " +
            "OBJETOEX TEXT, DESCRIPCION TEXT);";

}
