package com.develhope.demoController;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.ModelAttribute;

public class Libro {

    @Schema(name = "titolo", description = "Titolo del nostro libro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String titolo;
    @Schema(name = "autore", description = "Autore del nostro libro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String autore;
    @Schema(name = "editore", description = "Editore del nostro libro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String editore;
    @Schema(name = "pubblcazione", description = "Publicazione del nostro libro come intero di 4 cifre", requiredMode = Schema.RequiredMode.REQUIRED)
    private int pubblcazione;
    @Schema(name = "id", description = "Id del nostro libro salvato in db", requiredMode = Schema.RequiredMode.REQUIRED)
    private int id;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public int getPubblcazione() {
        return pubblcazione;
    }

    public void setPubblcazione(int pubblcazione) {
        this.pubblcazione = pubblcazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libro(String titolo, String autore, String editore, int pubblcazione, int id) {
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
        this.pubblcazione = pubblcazione;
        this.id = id;


    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                ", pubblcazione=" + pubblcazione +
                ", id=" + id +
                '}';
    }
}
