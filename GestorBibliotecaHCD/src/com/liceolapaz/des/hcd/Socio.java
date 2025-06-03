package com.liceolapaz.des.hcd;

public class Socio {
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String fecha_nacimiento;
    private int num_socio;
    private Libro[] libroSocio = new Libro[5];
    private int contadorLibrosSocio = 0;
    public Socio() {
    }
    public Socio(String nombre, String apellidos, String dni, String email, String fecha_nacimiento, int num_socio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.num_socio = num_socio;
    }
    protected boolean cogerLibro(Libro libro){
        if (libro.getDisponibilidad()) {
            if (contadorLibrosSocio < 5){
                libroSocio[contadorLibrosSocio] = libro; // Se sobreescribe en caso de que quitemos un libro
                libro.setDisponibilidad(false);
                contadorLibrosSocio++;
                return true;
            } else{
                System.out.println("TIENES YA 5 LIBROS, DEVUELVE ALGUNO RATA");
            }
        }else {
            System.out.println("LIBRO NO DISPONIBLE, ESTÁ PILLADO");
        }
        return false;
    }

    protected void totalLibros(){
        for (int i = 0; i < libroSocio.length -1;i++){
            if(libroSocio[i] != null){
                System.out.println(libroSocio[i].getTitulo());
            }
        }
    }
    protected boolean devolverLibro(Libro libro){
        if(libro.getDisponibilidad()){
            return false;
        }
        libroSocio[contadorLibrosSocio] = null;
        libro.setDisponibilidad(true);
        contadorLibrosSocio -= 1;
        return true;
    }
    public int getNum_socio() {
        return num_socio;
    }
}
