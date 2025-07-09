package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action"),
    ROMANCE ("Romance"),
    COMEDIA ("Comedy"),
    DRAMA ("Drama"),
    CRIMEN ("Crime");

    private String categoriaOmdb;
    Categoria (String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }
    public String getCategoriaOmdb() {
        return categoriaOmdb;
    }
    public static Categoria fromString(String categoriaOmdb) {
        for (Categoria c : Categoria.values()) {
            if (c.getCategoriaOmdb().equalsIgnoreCase(categoriaOmdb)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Categoría no encontrada: " + categoriaOmdb);
    }
}
