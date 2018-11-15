package software.ragp.com.projectotemporal.models;

public class Encargo {
    private int id;
    private String tipoObj, peso, valorD, origen, destino,
            largo, alto, ancho,tipoRiesgo, cantidad, escalaDeRiesgo,
            estado,objetoEx, descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoObj() {
        return tipoObj;
    }

    public void setTipoObj(String tipoObj) {
        this.tipoObj = tipoObj;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getValorD() {
        return valorD;
    }

    public void setValorD(String valorD) {
        this.valorD = valorD;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEscalaDeRiesgo() {
        return escalaDeRiesgo;
    }

    public void setEscalaDeRiesgo(String escalaDeRiesgo) {
        this.escalaDeRiesgo = escalaDeRiesgo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObjetoEx() {
        return objetoEx;
    }

    public void setObjetoEx(String objetoEx) {
        this.objetoEx = objetoEx;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
