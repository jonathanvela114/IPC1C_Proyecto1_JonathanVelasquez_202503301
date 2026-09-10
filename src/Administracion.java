public class Administracion {


    private Animales[] animales = new Animales[100]; //100 Animales
    private int contAnimales = 0;

    private String[][] espacios = new String[5][10]; //Espacio disponible

    private Usuario[] usuarios = new Usuario[10];
    private int contUsuario = 0;


    //agregar animales
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

    //buscar animales por código
    public Animales buscarporCodigo (String codigo){
        for (int i = 0; i < contAnimales; i++){
            if (animales[i].getCodigo().equals(codigo)){
                return animales[i];
            }
        }
        return null;
    }

    //editar estados de los animales
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

    //eliminar animales
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
    //listar animales
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
     public Administracion(){
        for (int fila = 0; fila < 5; fila++){
            for (int columna = 0; columna < 10; columna++){
                espacios[fila][columna] = "VACÍO";
            }
        }
     }

     public void mostrarEspacio(){
         System.out.println("MAPA DE ESPACIOS ");

         for (int fila = 0; fila < 5; fila++){
             for (int columna = 0; columna < 10; columna++){

                 System.out.print(espacios[fila][columna]);
             }
             System.out.println();
         }

     }

    public boolean asignarEspacio (String codigo, int fila, int columna) {
        Animales animalEncontrado = buscarporCodigo(codigo);
        if (animalEncontrado != null) {
            if (espacios[fila][columna].equals("[VACÍO]")){
                espacios[fila][columna] = "[ " + codigo + " ]";
            System.out.println("ANIMAL ASIGNADO A JAULA");
            return true;

        } else {
            System.out.println("ESTE ESPACIO YA SE ENCUENTRA OCUPADO");

            return false;
        }
    }
        System.out.println("EL ANIMAL NO EXISTE");
        return false;

    }

    public boolean desocuparJaula(int fila, int columna){
            if (!espacios[fila][columna].equals(" [VACÍO] ")){

                espacios[fila][columna] = " [VACIÍO] ";
                System.out.println("LA JAULA SE HA LIBERADO");
                return true;

            } else {
                System.out.println("LA JAULA YA SE ENCONTRABA VACÍA");
                return false;
            }

    }

    public boolean buscarUbicacion(String codigo){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (espacios[i][j].contains(codigo)){
                    System.out.println("EL ANIMAL: "+ codigo + "SE ENCUENTRE EN LA JAULA CON FILA: "+i+" COMLUMNA: " +j);
                    return true;
                }
            }

        }
        System.out.println("EL ANIMAL "+codigo+" NO TIENE NINGUN ESPACIO ASIGNADO");
        return false;
    }


}