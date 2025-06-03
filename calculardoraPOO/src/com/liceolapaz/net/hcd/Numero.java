package com.liceolapaz.net.hcd;

public interface Numero {
    Numero suma(Numero operando);
    Numero resta(Numero operando);
    Numero producto(Numero operando);

    Numero division(Numero operando);
    String mostrar();
}
