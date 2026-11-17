package es.daw;

public class Prestamo {

    private String codigo;
    private String material;
    private String solicitante;

    public Prestamo(String codigo, String material, String solicitante) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                "El código es obligatorio."
            );
        }

        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException(
                "El material es obligatorio."
            );
        }

        if (solicitante == null || solicitante.isBlank()) {
            throw new IllegalArgumentException(
                "El solicitante es obligatorio."
            );
        }

        this.codigo = codigo;
        this.material = material;
        this.solicitante = solicitante;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMaterial() {
        return material;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String mostrarResumen() {
        return "Código: " + codigo +
            " - Material: " + material +
            " - Solicitante: " + solicitante;
    }
}