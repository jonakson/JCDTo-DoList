package com.example.jonat.jcdto_dolist.Modelos;


import java.util.Date;

public class Tarea {

    private int id;
    private String titulo = new String();
    private String prioridad = "Media";
    private boolean estado = false;
    private String deadline;

    public Tarea(String titulo, String prioridad, boolean estado, String deadline) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
