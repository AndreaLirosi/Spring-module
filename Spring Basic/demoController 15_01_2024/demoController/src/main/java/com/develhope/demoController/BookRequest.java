package com.develhope.demoController;


import io.swagger.v3.oas.annotations.media.Schema;

public class BookRequest {
    @Schema(name = "titolo", description = "Titolo del nostro libro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String titolo;
    @Schema(name = "autore", description = "Autore del nostro libro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String autore;
    @Schema(name = "editore", description = "Editore del nostro libro", requiredMode = Schema.RequiredMode.REQUIRED)
    private String editore;
    @Schema(name = "publicazione", description = "Publicazione del nostro libro come intero di 4 cifre", requiredMode = Schema.RequiredMode.REQUIRED)
    private int publicazione;

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
        return publicazione;
    }

    public void setPubblcazione(int pubblcazione) {
        this.publicazione = pubblcazione;
    }


    public BookRequest(String titolo, String autore, String editore, int pubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
        this.publicazione = pubblicazione;
    }

}
