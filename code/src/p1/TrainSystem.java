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
import p1.utility.Searcher;
import p1.utility.Verifiable;

public class TrainSystem implements Verifiable{
    private ArrayList<Route> routes;
    private ArrayList<Station> stations;
    private ArrayList<Segment> segments;
    private ArrayList<Train> trains;
    private SystemStatus status;
    
    /*In the future, developer plans to store Stations as vertices and segments as edges in a tree */
    // private HashMap<Pair<Station,Station>,Segment> routesTree;

    /** Creates an empty {@code TrainSystem} instance.*/
    public TrainSystem() {
        this.routes = new ArrayList<>();
        this.stations = new ArrayList<>();
        this.segments = new ArrayList<>();
        this.trains = new ArrayList<>();
    }

    public ArrayList<Route> getRoutes() {return routes;}
    public ArrayList<Station> getStations() {return stations;}
    public ArrayList<Segment> getSegments() {return segments;}
    public ArrayList<Train> getTrains() {return trains;}
    public void addStation(String name){this.stations.add(new Station(name,RSStatus.Open,null,null));}
    public void removeStation(String name){Searcher.remove(this.stations, name);}
    public void openStation(String name){Searcher.open(this.stations, name);}
    public void closeStation(String name){Searcher.close(this.stations, name);}
    public void addSegment(String name){this.segments.add(new Segment(name,RSStatus.Open,null,null));}
    public void removeSegment(String name){Searcher.remove(this.segments, name);}
    public void openSegment(String name){Searcher.open(this.segments, name);}
    public void closeSegment(String name){Searcher.close(this.segments, name);}
    public void addRoute(String name){this.routes.add(new Route(name,RSStatus.Open,null));}
    public void removeRoute(String name){Searcher.remove(this.stations, name);}
    public void openRoute(String name){Searcher.open(this.stations, name);}
    public void closeRoute(String name){Searcher.close(this.stations, name);}
    public void addTrain(Train train){this.trains.add(train);}
    public void removeTrain(int id){
        for(int i = 0 ; i < this.trains.size() ; i++)
            if(this.trains.get(i).getId() == id) {
                this.trains.remove(id);
                break;
            }
    }
    public void registerTrain(int id , Route route){this.addTrain(new Train(route,id));}
    public void deRegisterTrain(int train){this.removeTrain(train);}
    public boolean containsStation(String station){return Searcher.getElementByName(this.stations, station) != null;}
    public boolean containsSegment(String segment){return Searcher.getElementByName(this.segments, segment) != null;}
    public boolean containsRoute(String route){return Searcher.getElementByName(this.routes, route) != null;}
    public boolean containsTrain(int train){
        for(int i = 0 ; i < this.trains.size() ; i++)
            if( this.trains.get(i).getId() == train) return true;
        return false;
    }
    public String getStationInfo(String station){return Searcher.getElementByName(this.stations, station).toString();}
    public String getSegmentInfo(String segment){return Searcher.getElementByName(this.segments, segment).toString();}
    public String getRouteInfo(String route){return Searcher.getElementByName(this.routes, route).toString();}
    public String getTrainInfo(int train ){
        for(int i = 0 ; i < this.trains.size() ; i++)
        if( this.trains.get(i).getId() == train) return this.trains.get(i).toString();
        return null;
    }
    public void setToWorking(){this.status = SystemStatus.Operational;}
    public void setPaused(){this.status = SystemStatus.Deadlocked;}
    public void setStopped(){this.status = SystemStatus.Finished;}
    public SystemStatus getCurrentStatus(){return this.status;}
    @Override public boolean verify() { return 
        routes.stream().allMatch((t)->{return t.verify();}) &&
        segments.stream().allMatch((t)->{return t.verify();}) &&
        stations.stream().allMatch((t)->{return t.verify();}) &&
        trains.stream().allMatch((t)->{return t.verify();});
    }
    public void advance(){}
}