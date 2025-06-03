public class Empresa {
    private static Empleado[] empleados;

    public static void main(String[] args){
        Empleado empleado1 = new Empleado(2000.70,19,"zarzo","del castillo","hugo","12345678G");
        Empleado empleado2 = new Empleado(100.60,33,"castro","quintela","lucas","1444445678G");
        Empleado empleado3 = new Empleado(100.60,33,"ce","hola","mar","4564322B");
        Jefe jefe = new Jefe(2000,32,"Pérez","delca","hugo","2344223F",242);

        empleados = new Empleado[4];
        empleados[0] = empleado1;
        empleados[1] = empleado2;
        empleados[2] = empleado3;
        empleados[3] = jefe;
        for (int i = 0; i < empleados.length; i++) {
            System.out.println(empleados[i].toString() + " -> " + empleados[i].calcularSalarioNeto());
            System.out.println(jefe.toString());
        }
    }
 }
