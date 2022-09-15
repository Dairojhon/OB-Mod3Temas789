import java.io.*;
import java.util.*;

public class Main {
    private static double num1;
    private static double num2;

    public static void main(String[] args) {
        seleccion();

    }

    static void seleccion() {

        boolean ok = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("por favor selecciona ingresando el numero de la opción que deseas: ");
            System.out.println("Presiona 0 si deseas ver el metodo de cadena invertida.");
            System.out.println("Presiona 1 si deseas ver el metodo para recorrer un arreglo unitario.");
            System.out.println("Presiona 2 si dese7as ver el metodo para recorrer y mostrar el arreglo bidimensional.");
            System.out.println("Presiona 3 si deseas ver el metodo para mostrar el resultado de un vector.");
            System.out.println("Presiona 4 si quieres saber problema de utilizar un Vector con la capacidad por defecto \n" +
                    "\tsi tuviésemos 1000 elementos para ser añadidos al mismo..");
            System.out.println("Presiona 5 si deseas ver el metodo para copiar un ArrayList a LinkedList");
            System.out.println("Presiona 6 si deseas ver el metodo para mostrar numeros impares del 1 al 10");
            System.out.println("Presiona 7 si deseas ver la funcion de excepciones para dividir por cero");
            System.out.println("Presiona 8 si deseas ver el metodo para copiar un fichero.");
            System.out.println("Presiona 9 si deseas ver miPrograma que copia un archivo sin su valores numericos.");

            try {

                int select = scanner.nextInt();


                switch (select) {
                    case 0 -> {
                        System.out.println("______________________________________________");
                        cadenaInvertida("hola mundo");
                    }
                    case 1 -> {
                        System.out.println("______________________________________________");
                        arrayUni("Aquí vamos aprendiendo");
                    }
                    case 2 -> {
                        System.out.println("______________________________________________");
                        arrayBidi();
                    }
                    case 3 -> {
                        System.out.println("______________________________________________");
                        ejVector();
                    }
                    case 4 -> {
                        System.out.println("______________________________________________");
                        System.out.println("El problema es el costo en memoria, ya que este crearia un nuevo vector y copiaria el vector anterior...\n" +
                                "\thasta alcanzar la capacidad de los 1000 elementos");
                    }
                    case 5 -> {
                        System.out.println("______________________________________________");
                        copyLists();
                    }
                    case 6 -> {
                        System.out.println("______________________________________________");
                        quitaNumPar();
                    }
                    case 7 -> {
                        System.out.println("______________________________________________");
                        try {
                            dividePorcero(5, 0);
                        } catch (Exception e) {
                            System.out.println("Esto no puede hacerse");
                        }
                        System.out.println("Demo de código");
                    }
                    case 8 -> {
                        System.out.println("______________________________________________");
                        copyFiles("D:\\OBejercicio.txt", "D:\\copia.txt");
                    }
                    case 9 -> {
                        System.out.println("______________________________________________");
                        MiPrograma programa = new MiPrograma();
                        programa.miPrograma("D:\\OBejercicio.txt", "D:\\claves.txt");
                    }
                }
                ok = true;
            } catch (InputMismatchException e) {
                System.out.println("______________________________________________");
                System.out.println("el numero ingresado es incorrecto, por favor ingresa un numero entre el 0 y 9");
                System.out.println("______________________________________________");

            }
        } while (!ok);

    }

    // cadena al reves
    static void cadenaInvertida(String cadena) {
        StringBuilder invertida = new StringBuilder();
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida.append(cadena.charAt(i));
        }
        System.out.println("el mensaje invertido es: " + invertida);
    }

    // 1. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
    static void arrayUni(String cadena) {
        System.out.println("los valores de este arreglo son: ");
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println("el valor de la cadena en la posición " + i + " es " + cadena.charAt(i));
        }
    }

    // 2. Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.
    static void arrayBidi() {
        Random rnd = new Random();
        int[][] arrayBi = new int[rnd.nextInt(10)][rnd.nextInt(10)];
        for (int i = 0; i < arrayBi.length; i++) {
            for (int j = 0; j < arrayBi.length; j++) {
                arrayBi[i][j] = rnd.nextInt(10);
            }
        }
        for (int i = 0; i < arrayBi.length; i++) {
            for (int j = 0; j < arrayBi.length; j++) {
                System.out.println("Estoy en la fila i " + i + " y la columna j " + j + " = " + arrayBi[i][j]);
            }
        }

    }

    // 3. Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.
    static void ejVector() {
        Vector<Integer> vector = new Vector<>();
        Random rnd = new Random();
        vector.add(rnd.nextInt(10));
        vector.add(rnd.nextInt(10));
        vector.add(rnd.nextInt(10));
        vector.add(rnd.nextInt(10));
        vector.add(rnd.nextInt(10));

        vector.remove(1);
        vector.remove(2);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println("El valor en la posición " + i + " es " + vector.get(i));
        }
    }

    /*4. Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
     */

    //5. Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.

    static void copyLists() {
        ArrayList<String> estacionesArrL = new ArrayList<>();
        estacionesArrL.add("Invierno");
        estacionesArrL.add("Primavera");
        estacionesArrL.add("Verano");
        estacionesArrL.add("otoño");
        LinkedList<String> estacionesLinkL = new LinkedList<>();
        estacionesLinkL.addAll(estacionesArrL);
        for (String estacion : estacionesArrL) {
            System.out.println("Los valores en el ArrayListo son: " + estacion);
        }
        for (String estacion : estacionesLinkL) {
            System.out.println("Los valores en la LinkedList son: " + estacion);
        }
    }

    /* 6.Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación,
    con otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final.
    Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.*/
    static void quitaNumPar() {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numeros.add(i);
        }
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {
                numeros.remove(i);
            }
            System.out.println("El valor actual en el Arraylist es: " + numeros.get(i));
        }
    }

    /* 7. Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
    ArithmeticException que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la excepción,
    mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso: "Demo de código".
     */

    static void dividePorcero(double num1, double num2) throws ArithmeticException {
        Main.num1 = num1;
        Main.num2 = num2;
        double resultado = 0;
        resultado = num1 / num2;
        throw new ArithmeticException();

    }

    /*8. Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut".
    La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
     */

    static void copyFiles(String fileIn, String fileOut) {
        try {
            InputStream fichero = new FileInputStream(fileIn);
            try {
                byte[] datos = fichero.readAllBytes();

                for (byte dato : datos) {

                    System.out.print((char) dato);
                }
                PrintStream datosCopiados = new PrintStream(fileOut);
                datosCopiados.write(datos);
            } catch (IOException e) {
                System.out.println("no puedo leer el fichero" + e.getMessage());
            }
        } catch (FileNotFoundException nf) {
            System.out.println("Se ha encontrado un error en la ejecución del programa" + nf.getMessage());
        }
    }

    /*Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un HashMap
    y un ArrayList, LinkedList o array. */

}