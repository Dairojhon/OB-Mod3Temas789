import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MiPrograma {
    void miPrograma(String fileIn, String fileOut)
    {
        try
        {
            InputStream fichero = new FileInputStream(fileIn);
            try
            {
                byte[] datos=fichero.readAllBytes();
                String[] personas = {"Jhon","Diana","Oscar","Cristian","Carolina",
                        "Jonathan", "Jose","Claudia","Daniela","Diego"};
                int[] numeros = new int[10];
                ArrayList<Integer> claves=new ArrayList<Integer>();
                ArrayList<Byte>datosActualizados= new ArrayList<Byte>();
                for(int i=1;i<10;i++)
                {
                    numeros[i]=i;
                }
                System.out.println("Aquí mostramos el primer fichero");
                for (byte dato:datos)
                {
                    byte noNumero = 0;
                    char caracter = (char)dato;
                    for (int numero : numeros) {
                        if (Character.getNumericValue(caracter) == numero) {
                            //se agrega al arrayList los valores numericos del archivo
                            claves.add(Character.getNumericValue((char) dato));
                            break;
                        }
                        else if(!claves.contains(numero)){
                            noNumero=dato;
                        }


                    }
                    datosActualizados.add(noNumero);

                    System.out.print((char)dato);

                }
                HashMap<Integer,String> empleados=new HashMap<>();
                for(int i=0;i< claves.size();i++)
                {
                    empleados.put(claves.get(i),personas[i]);
                }
                System.out.println("__________________________________________________________");
                System.out.println("Aqui mostramos los valores numericos del fichero");
                for (int clave:claves)
                {
                    System.out.print(clave);
                }
                System.out.println();
                System.out.println("__________________________________________________________");
                System.out.println("Aqui mostramos el fichero sin valores numericos");
                for (byte datoact:datosActualizados)
                {
                    System.out.print((char) datoact);
                }
                System.out.println();
                System.out.println("__________________________________________________________");
                System.out.println("Aqui mostramos el mapa");
                for(Map.Entry empleado: empleados.entrySet())
                {
                    System.out.println("La clave y el empleado son: " +empleado.getKey()+": "+empleado.getValue() );
                }

                PrintStream datosCopiados=new PrintStream(fileOut);
                for (byte datoact: datosActualizados)
                {
                    datosCopiados.write(datoact);
                }
                datosCopiados.println(empleados);

            }catch (IOException e)
            {
                System.out.println("no puedo leer el fichero"+e.getMessage());
            }
        }catch (FileNotFoundException nf)
        {
            System.out.println("Se ha encontrado un error en la ejecución del programa"+nf.getMessage());
        }
    }
}
