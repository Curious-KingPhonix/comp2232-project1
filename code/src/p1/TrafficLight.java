package p1;

public class TrafficLight extends Station{
    private int id;
    private Light colour;
    protected void change(){ }
    public void changeLight() { }
    public boolean lightColour(){return true;}
    @Override
    public boolean verify() {return (colour != null);}
}