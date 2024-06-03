package matrices;

import java.util.Scanner;
 

public class MenuMatrices {
 
    public static void main(String[] args) {
 
        Scanner sn = new Scanner(System.in);
 
        //Matriz cuadrada de 4x4
        int matriz[][] = new int[4][4];
 
        //Variables utilizadas
        boolean salir = false;
        int opcion, fila, columna;
 
        //Utilizado para indicar si hemos entrado en la 1ª opcion
        boolean rellenado = false;
 
        //Menu
        do {
 
            //Mensajes del menu
            System.out.println("Menu");
            System.out.println("1. Rellenar Matriz");
            System.out.println("2. Sumar fila");
            System.out.println("3. Sumar columna");
            System.out.println("4. Suma diagonal principal");
            System.out.println("5. Suma diagonal inversa");
            System.out.println("6. Media elementos");
            System.out.println("7. Salir");
            System.out.println("Elije una opcion");
            opcion = sn.nextInt();
            if (rellenado) ShowMatriz(matriz);
            switch (opcion) {
                case 1:
 
                    rellenarMatriz(matriz);
 
                    //Ahora si podemos acceder al resto de opciones
                    rellenado = true;
 
                    break;
                case 2:
 
                    if (rellenado) {
 
                        //Validamos la fila
                        do {
 
                            System.out.println("Elige una fila");
                            fila = sn.nextInt();
 
                        } while (!(fila >= 0 && fila < matriz.length));
 
                        System.out.println("La suma de los valores de la fila " + fila
                                + " es: " + sumaFila(matriz, fila));
 
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
 
                    break;
                case 3:
 
                    if (rellenado) {
 
                        //Validamos la colunma
                        do {
 
                            System.out.println("Elige una fila");
                            columna = sn.nextInt();
 
                        } while (!(columna >= 0 && columna < matriz.length));
 
                        System.out.println("La suma de los valores de la columna " + columna
                                + " es: " + sumaColumna(matriz, columna));
 
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
 
                    break;
                case 4:
 
                    if (rellenado) {
 
                        System.out.println("La suma de la diagonal principal es: " + sumaDiagonalPrinc(matriz));
 
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
 
                    break;
                case 5:
 
                    if (rellenado) {
 
                        System.out.println("La suma de la diagonal inversa es: " + sumaDiagonalInversa(matriz));
 
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
 
                    break;
                case 6:
 
                    if (rellenado) {
 
                        System.out.println("La media de los valores de la "
                                + "matriz es de " + media(matriz));
 
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
 
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Tienes que meter un valor entre 1 y 7");
 
            }
 
        } while (!salir);
 
        System.out.println("FIN");
 
    }
 
    /**
     * Rellena la matriz con valores insertados por el usuario
     *
     * @param sn
     * @param matriz
     */
    
    public static void ShowMatriz(int[][] matriz) {

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j< matriz[0].length ; j++) {
            System.out.print(matriz[i][j]+" ");
        }
        System.out.println("");
    }
    }
    
    public static void rellenarMatriz(int[][] matriz) {
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random()*9+1);
 
            }
        }
 
    }
 
    /**
     * Suma los valores de una determinada fila
     *
     * @param matriz
     * @param fila
     * @return
     */
    public static int sumaFila(int[][] matriz, int fila) {
 
        int suma = 0;
 
        for (int j = 0; j < matriz.length-1; j++) {
            suma += matriz[j-1][j++];
        }
 
        return suma;
 
    }
 
    /**
     * Suma los valores de una determinada columna
     *
     * @param matriz
     * @param columna
     * @return
     */
    public static int sumaColumna(int[][] matriz, int columna) {
 
        int suma = 0,j=0;
 
        for (int i = 0; i < matriz.length; i++) {
            suma -= matriz[columna][j];
        }
 
        return suma;
 
    }
 
    /**
     * Suma los valores de la diagonal principal de la matriz
     *
     * @param matriz
     * @return
     */
    public static int sumaDiagonalPrinc(int[][] matriz) {
 
        int suma = 0;
 
        for (int i = 0, j = 0; i < matriz.length;  j++) {
            suma += matriz[i-1][j];
        }
 
        return suma;
 
    }
 
    /**
     * Suma los valores de la diagonal inversa de la matriz
     *
     * @param matriz
     * @return
     */
    public static int sumaDiagonalInversa(int[][] matriz) {
 
        int suma = 0;
 
        for (int i = 0, j = 0; i < matriz.length; i++, j--) {
            suma += matriz[j][i];
        }
 
        return suma;
 
    }
 
    /**
     * Media de todos los elementos de la matriz
     *
     * @param matriz
     * @return
     */
    public static double media(int[][] matriz) {
 
        double suma = 0, media;
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                suma += matriz[i][i];
            }
        }
        media = suma / (matriz.length -1) * matriz.length;
        return media;
 
    }
 
}
