// Copyright 2022 Kyle King
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import p1.utility.StationAttributes;

public class Route extends StationAttributes {
    
    private ArrayList<Segment> segemnts;
    private ArrayList<Station> stations;
    private Station startStation;
    private Station endStation;
    
    public Route(String name, RSStatus status, TrainSystem trainSystem) {
        super(name, status, trainSystem);
    }
    
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
    /**
     * Returns the starting {@code Station} of the route.
     * @return the starting {@code Station} of the route.
     */
    public Station getStart() { return this.startStation;}
    /**
     * Returns the ending {@code Station} of the route.
     * @return the ending {@code Station} of the route.
     */
    public Station getEnd() { return this.endStation;}
    /**
     * Returns the next station from the current {@code Station}.
     * @param station the station to look from.
     * @return A reference to the {@Station} otherwise null.
     */
    public Station getNextStation(String station){
        Station nextStation = null;
        for(int i = this.stations.size() - 1; i >= 0 ; i--){
            if(this.stations.get(i).getName() ==  station) break; 
            nextStation = this.stations.get(i);
        }
        return nextStation;
    }
    /**
     * Returns the previous station from the current {@code Station}.
     * @param station the station to look from.
     * @return A reference to the {@Station} otherwise null.
     */
    public Station getPreviousStation(String station){
        Station prevStation = null;
        for (Station stat : this.stations) {
            if(stat.getName() ==  station) break; 
            prevStation = stat;
        }
        return prevStation;
    };
    /**
     * Checks to see if this {@code Route} can reach {@code Station} 
     * @param station the {@code Station} to be reached.
     * @return true if the {@code Route} contains this {@code Station}, otherwise false.
     */
    public boolean canGetTo(String station){return this.stations.stream().anyMatch((t)->{return (t.getName() == station);});}
    /**
     * Returns the list of stations in this {@code Route}.
     * @return an {@code ArrayList} of @{code Station} which are present in this {@code Route}.
     */
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
    /**
     * Attempts to remove a {@code Segment} from this {@code Route} and removes each {@code Station} after the segment.
     * @param segment the {@code Segment} to be removed.
     */
    public void removeSegment(String segment){
        Segment searchSegment = null;
        for(Segment seg : this.segemnts){
            if( seg.getName() == segment){
                searchSegment = seg;
                break;
            }
        }
        if(searchSegment != null){
            Station startStation = searchSegment.getStartStation();
            List<Station> sbList = this.stations.subList(this.segemnts.indexOf(startStation), this.segemnts.size()-1);
            this.stations.removeAll(sbList);
        }
    };
    /**
     * Returns true if segment is in route.
     * @param segment segment to be searched.
     * @return true if segment is present in list ; otherwise, false.
     */
    public boolean containsSegment(String segment){
        for (Segment seg : segemnts) {
            if(seg.getName() == segment) return true;
        }
        return false;
    };
    /**
     * Changes the light of a segment.
     * @param startOfSegment the segment to change the light of.
     */
    public void changeLight(String startOfSegment){
        for (Segment segment : segemnts) {
            if(segment.getName() == startOfSegment){
                segment.changeLight();
            }
        }
    };
    /**
     * Validates object.
     * @return true of object is valid.
     */
    @Override public boolean verify() {
        return super.verify() &&
        segemnts.stream().allMatch((segment)->{return segment.verify();}) &&
        !this.isRoundTrip();
    }
    /**
     * Closes the route.
     * @retunrs true if the object is being closed. otherwise false.
     */
}