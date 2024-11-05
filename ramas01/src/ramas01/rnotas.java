package ramas01;

import java.util.Scanner;

public class rnotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sumaNotas = 0;
        double notaMaxima = Double.MIN_VALUE; 
        double notaMinima = Double.MAX_VALUE; 
        int alumnos = 0;

        while (true) {
            int menus = dimeEntero("Selecciona un número: \n1 - Agregar nota de un alumno  \n2 - Calcular promedio. \n3 - Mostrar nota más alta. \n4 - Mostrar nota más baja. \n5 - Contar alumnos aprobados.\n0 - Salir", sc);

            switch (menus) {
                case 1:
                    double nota = agregarNota(sc);
                    if (nota != -1) { 
                        sumaNotas += nota;
                        alumnos++;
                        if (nota > notaMaxima) {
                            notaMaxima = nota; 
                        }
                        if (nota < notaMinima) {
                            notaMinima = nota;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Promedio: " + calcularPromedio(sumaNotas, alumnos));
                    break;
                case 3:
                    System.out.println("Nota más alta: " + notaMaxima(notaMaxima));
                    break;
                case 4:
                    System.out.println("Nota más baja: " + notaMinima(notaMinima));
                    break;
                case 5:
                    System.out.print("Introduce la nota de corte: ");
                    System.out.println("Alumnos aprobados: " + contarAprobados(sumaNotas, alumnos, sc.nextDouble()));
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    public static int dimeEntero(String intStart, Scanner scanner) {
        while (true) {
            System.out.println(intStart);
            String entrada = scanner.nextLine();
            try {
                int entero = Integer.parseInt(entrada);
                return entero;
            } catch (Exception e) {
                System.out.println("Error, número no valido.");
            }
        }
    }

    public static double agregarNota(Scanner scanner) {
        System.out.print("Introduce nota: ");
        String entrada = scanner.nextLine();
        try {
            double nota = Double.parseDouble(entrada);
            if (nota < 0 || nota > 10) {
                System.out.println("Nota no válida.");
                return -1; 
            } else {
                return nota;
            }
        } catch (Exception e) {
            System.out.println("Error, número no reconocido.");
            return -1; 
        }
    }

    public static double calcularPromedio(double sumaNotas, int alumnos) {
        if (alumnos == 0) {
            return 0;
        } else {
            return sumaNotas / alumnos;
        }
    }

    public static double notaMaxima(double notaMaxima) {
        return notaMaxima;
    }

    public static double notaMinima(double notaMinima) {
        return notaMinima;
    }

    public static int contarAprobados(double sumaNotas, int alumnos, double notaCorte) {
        int nAprobados = 0;
        if (alumnos == 0) {
            return nAprobados;
        } else {
            double promedio = sumaNotas / alumnos; 
            if (promedio >= notaCorte) {
                nAprobados = alumnos;
            }
            return nAprobados;
        }
    }
}
