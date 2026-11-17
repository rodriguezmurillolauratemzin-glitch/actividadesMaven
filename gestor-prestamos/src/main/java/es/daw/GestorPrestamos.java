package es.daw;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class GestorPrestamos implements Exportable {

    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void registrarPrestamo(String codigo, String material, String solicitante) {

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equalsIgnoreCase(codigo)) {
                throw new IllegalStateException(
                    "Ya existe un préstamo con ese código."
                );
            }
        }

        Prestamo nuevo = new Prestamo(codigo, material, solicitante);
        prestamos.add(nuevo);
    }

    public Prestamo buscarPorCodigo(String codigo) {

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equalsIgnoreCase(codigo)) {
                return prestamo;
            }
        }

        return null;
    }

    public void mostrarPrestamos() {

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo.mostrarResumen());
        }
    }

    public int getNumeroPrestamos() {
        return prestamos.size();
    }

    // Exportar informe TXT
    @Override
    public void exportar(String ruta) {

        StringBuilder contenido = new StringBuilder();

        contenido.append("INFORME DE PRÉSTAMOS\n");
        contenido.append("--------------------\n");

        contenido.append("Número total de préstamos: ")
                .append(prestamos.size())
                .append("\n\n");

        for (Prestamo prestamo : prestamos) {
            contenido.append(prestamo.mostrarResumen());
            contenido.append("\n");
        }

        try {
            Files.writeString(Path.of(ruta), contenido.toString());

            System.out.println("Informe TXT exportado correctamente: " + ruta);

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo exportar el TXT.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }

    // Exportar informe PDF
    public void exportarPDF(String ruta) {

        Document documento = new Document();

        try (OutputStream salida = Files.newOutputStream(Path.of(ruta))) {

            PdfWriter.getInstance(documento, salida);

            documento.open();

            documento.add(new Paragraph("INFORME DE PRÉSTAMOS"));
            documento.add(new Paragraph("--------------------"));
            documento.add(new Paragraph(" "));

            documento.add(new Paragraph(
                "Número total de préstamos: " + prestamos.size()
            ));

            documento.add(new Paragraph(" "));

            for (Prestamo prestamo : prestamos) {
                documento.add(new Paragraph(prestamo.mostrarResumen()));
                documento.add(new Paragraph(" "));
            }

            documento.close();

            System.out.println("Informe PDF exportado correctamente: " + ruta);

        } catch (DocumentException | IOException e) {

            if (documento.isOpen()) {
                documento.close();
            }

            System.out.println("ERROR: No se pudo exportar el PDF.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }
}