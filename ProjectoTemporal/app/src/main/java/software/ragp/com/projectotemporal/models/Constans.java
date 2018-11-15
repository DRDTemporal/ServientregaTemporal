package software.ragp.com.projectotemporal.models;

public class Constans {
    public static final String DATABASE_NAME="datos.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_ENCARGO="CREATE TABLE ENCARGO(IDENCARGO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "TIPOOBJ TEXT, PESO TEXT, VALORD TEXT, ORIGEN TEXT, DESTINO TEXT, LARGO TEXT, ALTO TEXT, " +
            "ANCHO TEXT, TIPORIESGO TEXT, CANTIDAD TEXT, ESCALARIESGO TEXT, ESTADO TEXT, " +
            "OBJETOEX TEXT, DESCRIPCION TEXT);";

    public static final String [] listaDEpartamentos ={
            "Amazonas-Leticia", "Antioquia-Medellín", "Arauca-Arauca", "Atlántico-Barranquilla",
            "Bolívar-Cartagena de Indias", "Boyacá-Tunja", "Caldas-Manizales", "Caquetá-Florencia", "Casanare-Yopal",
            "Cauca-Popayán", "Cesar-Valledupar", "Chocó-Quibdó", "Córdoba-Montería", "Cundinamarca-Bogotá", "Guainía-Inírida",
            "Guaviare-San José del Guaviare", "Huila-Neiva", "La Guajira-Riohacha", "Magdalena-Santa Marta", "Meta-Villavicencio",
            "Nariño-Pasto", "Norte de Santander-San José de Cúcuta", "Putumayo-Mocoa", "Quindío-Armenia", "Risaralda-Pereira",
            "San Andrés y Providencia-San Andrés", "Santander-Bucaramanga", "Sucre-Sincelejo", "Tolima-Ibagué",
            "Valle del Cauca-Cali", "Vaupés-Mitú", "Vichada-Puerto Carreño"
    };

}
