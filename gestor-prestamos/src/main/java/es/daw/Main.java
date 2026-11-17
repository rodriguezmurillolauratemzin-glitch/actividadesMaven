
package es.daw;

public class Main {

    public static void main(String[] args) {

        GestorPrestamos gestor = new GestorPrestamos();

        // 1. Registrar dos préstamos
        System.out.println("REGISTRO DE PRÉSTAMOS");
        System.out.println("---------------------");

        try {
            gestor.registrarPrestamo("P001", "Portátil HP", "Ana");
            gestor.registrarPrestamo("P002", "Ratón inalámbrico", "Luis");

            System.out.println("Préstamos registrados correctamente.");

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Intentar registrar un código duplicado
        System.out.println("\nPRUEBA DE CÓDIGO DUPLICADO");
        System.out.println("--------------------------");

        try {
            gestor.registrarPrestamo("P001", "Teclado", "Marta");

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo registrar: " + e.getMessage());
        }

        // 3. Mostrar todos los préstamos
        System.out.println("\nLISTADO DE PRÉSTAMOS");
        System.out.println("--------------------");

        gestor.mostrarPrestamos();

        // 4. Comprobar el número de préstamos
        System.out.println("\nTOTAL DE PRÉSTAMOS");
        System.out.println("------------------");

        System.out.println("Número total: " + gestor.getNumeroPrestamos());

        // 5. Buscar un préstamo existente
        System.out.println("\nBUSCAR PRÉSTAMO P001");
        System.out.println("--------------------");

        Prestamo encontrado = gestor.buscarPorCodigo("P001");

        if (encontrado != null) {
            System.out.println(encontrado.mostrarResumen());
        } else {
            System.out.println("Préstamo no encontrado.");
        }

        // 6. Buscar un préstamo inexistente
        System.out.println("\nBUSCAR PRÉSTAMO P999");
        System.out.println("--------------------");

        Prestamo inexistente = gestor.buscarPorCodigo("P999");

        if (inexistente != null) {
            System.out.println(inexistente.mostrarResumen());
        } else {
            System.out.println("Préstamo no encontrado.");
        }

        // 7. Exportar informe TXT
        System.out.println("\nEXPORTAR INFORME TXT");
        System.out.println("--------------------");

        gestor.exportar("prestamos.txt");

        // 8. Exportar informe PDF
        System.out.println("\nEXPORTAR INFORME PDF");
        System.out.println("--------------------");

        gestor.exportarPDF("prestamos.pdf");

        // 9. Comprobar el resultado final
        System.out.println("\nRESULTADO FINAL");
        System.out.println("----------------");

        System.out.println("Total de préstamos: " + gestor.getNumeroPrestamos());

        gestor.mostrarPrestamos();
    }
}
