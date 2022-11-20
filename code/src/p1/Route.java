package p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Route extends TrainStop {
    private ArrayList<Segment> segemnts;
    private ArrayList<Station> stations;

    /**
     * Traverses the segments sequentially until the start station is encountered again.
     * @return returns true if there're not duplicate segments, stations and the start station matches the end station of the route. 
     */
    public boolean isRoundTrip(){
        Station homeStation = null, prevStation = null,start,end;
        HashMap<Station,Boolean> visit = new HashMap<>();
        boolean isRoundTrip = true;
        for (Segment segment : segemnts) {
            start = segment.getStartStation();
            end = segment.getEndStation();
            if(homeStation == null) {
                homeStation = start;
                prevStation = end;
                visit.put(homeStation, true);
                visit.put(prevStation,true);
                continue;
            };
            if(!prevStation.equals(start) || visit.getOrDefault(start, false) || visit.getOrDefault(end,false) ) {isRoundTrip= false;break;};
            visit.put(start, true);
            visit.put(end, true);
            prevStation = end;
        }
        return isRoundTrip && homeStation.equals(prevStation);
    }
    public Station getStart() { return null;}
    public Station getEnd() { return null;}
    public Station getNextStation(String station){return null;};
    /**
     * Returns the previous station from the current {@code Station}.
     * @param station the station to look from.
     * @return A reference to the {@Station} otherwise null.
     */
    public Station getPreviousStation(String station){
        Station prevStation = null;
        for (Station stat : this.stations) {
            if(stat.name ==  station) break; 
            prevStation = stat;
        }
        return prevStation;
    };
    public boolean canGetTo(String station){return false;}
    public ArrayList<Station> getStationList() {
        return stations;
    }
    /**
     * Appends a single segment to the route.
     * Updates the end station of the route.
     * @param segment a segment to be added to the route.
     */
    public void addSegment(Segment segment){
        if(segment != null){
            this.segemnts.add(segment);
            if(this.segemnts.size() == 1) this.startStation = segment.getStartStation();
            this.endStation = segment.getEndStation();
            this.stations.add(segment.getStartStation());
            this.stations.add(segment.getEndStation());
        }
    };
    /**
     * Appends a list of segments to the route.
     * Updates the end station of the route.
     * @param segments a list of segments to be appended.
    */
    public void addSegments(List<Segment> segments){
        this.endStation = this.segemnts.get(this.segemnts.size()-1).getEndStation();
    };
    public void removeSegment(String segment){};
    public void containsSegment(String segment){};
    public void changeLight(String startOfSegment){};
    @Override public boolean verify() {
        return super.verify() &&
        segemnts.stream().allMatch((segment)->{return segment.verify();}) &&
        !this.isRoundTrip();
    }
    @Override public boolean close() {return false;}
    @Override public boolean open() {return false;} 
}