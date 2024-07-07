package py.com.lincoln.todo_list_application.strategies;

public class Vehiculo {
    private AceleracionStrategy aceleracionStrategy;

    public void setAceleracionStrategy(AceleracionStrategy aceleracionStrategy){
        this.aceleracionStrategy = aceleracionStrategy;
    }

    public void acelerar(){
        aceleracionStrategy.acelerar();
    }

}
