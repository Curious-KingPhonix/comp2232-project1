package p1;

public class Train implements Verifiable {
    private int id , timeRegistered , startTime;
    private Station currentLocation;
    public boolean isRegistered(){return true;}
    public boolean whenRegistered(){return true;}
    public int register(int time){return 0;}
    public void start(){}
    public void advance(){}
    public String currentStation(){return null;}
    public String nextStation(){return null;}
    public void changeRoute(Route route){}
    @Override public boolean verify() {return false;}
}