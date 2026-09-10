public class Administracion {


    private Animales[] animales = new Animales[100]; //100 Animales
    private int contAnimales = 0;

    private String[][] espacios = new String[5][10]; //Espacio disponible

    private Usuario[] usuarios = new Usuario[10];
    private int contUsuario = 0;


    public boolean agregarAnimal(Animales nuevoAnimal) {
        if (contAnimales >= animales.length) {
            System.out.println("EL REFUGIO SE ENCUENTRA LLENO"); //Espacio llenos
            return false;
        }

        animales[contAnimales] = nuevoAnimal;

        contAnimales++; //Se agrega uno al contador

        System.out.println("ANIMAL REGISTRADO CORRECTAMENTE");
        return true;

    }

    public Animales buscarporCodigo (String codigo){
        for (int i = 0; i < contAnimales; i++){
            if (animales[i].getCodigo().equals(codigo)){
                return animales[i];
            }
        }
        return null;
    }

    public boolean editarEstado(String codigo, String estadoNuevo){
        Animales AnimalEncontrado = buscarporCodigo(codigo);
        if(AnimalEncontrado != null){
            AnimalEncontrado.setEstado(estadoNuevo);
            System.out.println("ESTADO ACTUALIZADO CORRECTAMENTE");
            return true;
        }

        System.out.println("NO SE ENCONTRO LA ANIMAL");
        return false;
    }

    public boolean eliminarAnimales(String codigo){
        Animales AnimalEliminado = buscarporCodigo(codigo);
        for (int i = 0; i < contAnimales; i++){
            if (animales[i].getCodigo().equals(codigo)){
                animales[i] = animales[contAnimales-1];

                animales[contAnimales-1] = null;
                contAnimales--;
                System.out.println("ANIMAL ELIMINADO CORRECTAMENTE");


                return true;

            }
        }
        System.out.println("NO SE ENCONTRO EL ANIMAL");
        return false;
    }
    public void listarAnimales(){
        if (contAnimales == 0){
            System.out.println("NO HAY ANIMALES REGISTRADO EN EL SISTEMA");
            return;

        }
        System.out.println("LISTADO DE ANIMALES RESGISTRADOS");
        for (int i = 0; i < contAnimales; i++){
            System.out.println("CÓDIGO: " +animales[i].getCodigo()+
                                "NOMBRE: " +animales[i].getNombre()+
                                "ESPECIE: " +animales[i].getEspecie());
        }
    }
}