import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Animales {
    private String nombre;
    private String estado;
    private String especie;
    private String codigo;

    public Animales(String nombre, String estado, String especie, String codigo){
        this.nombre = nombre;
        this.estado = estado;
        this.especie = especie;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getEspecie() {
        return especie;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
