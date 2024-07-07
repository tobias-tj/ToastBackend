package py.com.lincoln.todo_list_application.strategies;

public class VehiculosApplication {
    public static void main(String[] args){
        Vehiculo auto = new Vehiculo();
        Vehiculo moto = new Vehiculo();

        auto.setAceleracionStrategy(new AcelerarAuto());
        moto.setAceleracionStrategy(new AcelerarMotocicleta());

        auto.acelerar();
        moto.acelerar();
    }
}
