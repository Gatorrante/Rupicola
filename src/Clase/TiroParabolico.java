package Clase;

public class TiroParabolico {

    public double result;
    public double velocidadI, angulo, tiempo, angulorad;

    public  double   calalturamaxima(double velocidadI, double angulo) {
        angulorad = Math.toRadians(angulo);
        result = (velocidadI * Math.sin(angulorad)) * ((velocidadI * Math.sin(angulorad)) / 9.81) + (0.5 * -9.81 * Math.pow(((velocidadI * Math.sin(angulorad)) / 9.81), 2));
        double x = result;
        return  x;
    }

    public double  caldistanciamaxima(double velocidadI, double angulo) {
        angulorad = Math.toRadians(angulo);
        result = (velocidadI * Math.cos(angulorad)) * (((velocidadI * Math.sin(angulorad)) / 9.81)) * 2;
        double x=result;
        return x;
    }

    public double  altura(double velocidadI, double angulo, double tiempo) {
        angulorad = Math.toRadians(angulo);
        result = ((velocidadI * Math.sin(angulorad)) * tiempo) + (0.5 * -9.81 * Math.pow(tiempo, 2));
        double x=result;
        return x;
    }

    public double  alcancemax(double velocidadI, double angulo, double tiempo) {
        angulorad = Math.toRadians(angulo);
        result = velocidadI * Math.cos(angulorad) * tiempo;
        double x=result;
        return x;
    }

    public double  velocidad(double velocidadI, double angulo, double tiempo) {
        angulorad = Math.toRadians(angulo);
        result = Math.sqrt(Math.pow((velocidadI * Math.sin(angulorad)) + (-9.81 * tiempo), 2) + (Math.pow(velocidadI * Math.cos(angulorad), 2)));
        double x=result;
        return x;
    }

    public double  tiempodevuelo(double velocidadI, double angulo) {
        angulorad = Math.toRadians(angulo);
        result = (((velocidadI * Math.sin(angulorad)) / 9.81) * 2);
        double x=result;
        return x;
    }
}
