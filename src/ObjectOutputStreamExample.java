import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {

        //escribirTiposDato();
        //leerTiposDato();
        //escribirUTF();
        //escribirArray();
        //leerArray();
        escribirObjetosPersonalizados();
        leerObjetosPersonalizados();

    }

    private static void escribirTiposDato() {
        try (OutputStream fos = new FileOutputStream("objects.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeInt(4);
            oos.writeDouble(3.1416);
            oos.writeBoolean(true);
            oos.writeLong(123456789L);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerTiposDato(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objects.txt"));

            System.out.println(ois.readInt());
            System.out.println(ois.readDouble());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readLong());

            ois.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirUTF(){
        try (OutputStream fos = new FileOutputStream("utf.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeUTF("Hola mundo");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirArray(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("array.txt"))){
            ArrayList<String> nombres = new ArrayList<>();
            nombres.add("Pepe");
            nombres.add("Paco");
            nombres.add("Pepa");
            nombres.add("Pipo");

            oos.writeObject(nombres);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerArray(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("array.txt"))){
            ArrayList<String> listaLeida = (ArrayList<String>)ois.readObject();
            System.out.println(listaLeida.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirObjetosPersonalizados(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objetosPersonalizados.txt"))){
            List<Alumno> alumnos = new ArrayList<Alumno>();
            alumnos.add(new Alumno("Steve", "Jobs", "estebancurros@apple.com"));
            alumnos.add(new Alumno("William", "Gates", "guillermopuertas@outlook.com"));
            alumnos.add(new Alumno("Sergey", "Brin", "sergio@gmail.com"));

            oos.writeObject(alumnos);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerObjetosPersonalizados(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objetosPersonalizados.txt"))){
            ArrayList<Alumno> listaLeida = (ArrayList<Alumno>) ois.readObject();
            System.out.println(listaLeida.size());

            for(Alumno alumno: listaLeida){
                System.out.println(alumno);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
