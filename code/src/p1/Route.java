package p1;

import java.util.HashSet;

public class Route extends AbstractStation {
    public boolean isRoundTrip(){ return true;}
    public Station getStart() { return null;}
    public Station getEnd() { return null;}
    public Station getNextStation(String station){return null;};
    public Station getPreviousStation(String station){return null;};
    public boolean canGetTo(String station){return false;}
    public void addSegment(Segment segment){};
    public void addSegments(HashSet segments){};
    public void removeSegment(String segment){};
    public void containsSegment(String segment){};
    public void changeLight(String startOfSegment){};
    @Override public boolean verify() {return false; }
    @Override public boolean close() {return false;}
    @Override public boolean open() {return false;} 
}