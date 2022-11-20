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
import java.util.List;

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

    public void addStation(String name){
        this.stations.add(new Station(name,RSStatus.Open,null,null));
    }
    public void removeStation(String name){
        Searcher.remove(this.stations, name);
    }
    public void openStation(String name){
        Searcher.open(this.stations, name);
    }
    public void closeStation(String name){
        Searcher.close(this.stations, name);
    }
    public void addSegment(String name){
        this.segments.add(new Segment(name,RSStatus.Open,null,null));
    }
    public void removeSegment(String name){
        Searcher.remove(this.segments, name);
    }
    public void openSegment(String name){
        Searcher.open(this.segments, name);
    }
    public void closeSegment(String name){
        Searcher.close(this.segments, name);
    }
    public void addRoute(String name){
        this.routes.add(new Route(name,RSStatus.Open,null));
    }
    public void removeRoute(String name){
        Searcher.remove(this.stations, name);
    }
    public void openRoute(String name){
        Searcher.open(this.stations, name);
    }
    public void closeRoute(String name){
        Searcher.close(this.stations, name);
    }
    public void addTrain(String name){}
    public void removeTrain(String name){}
    public void registerTrain(int id , Route route){}
    public void deRegisterTrain(int train){}
    public boolean containsStation(String station){return false;}
    public boolean containsSegment(String segment){return false;}
    public boolean containsRoute(String route){return false;}
    public boolean containsTrain(int train){return false;}
    public String getStationInfo(String station){return null;}
    public String getSegmentInfo(String station){return null;}
    public String getRouteInfo(String station){return null;}
    public String getTrainInfo(int train ){return null;}
    public void setToWorking(){}
    public void setPaused(){}
    public void setStopped(){}
    public void currentStatus(){}
    public void advance(){}
    @Override public boolean verify() { return 
        routes.stream().allMatch((t)->{return t.verify();}) &&
        segments.stream().allMatch((t)->{return t.verify();}) &&
        stations.stream().allMatch((t)->{return t.verify();}) &&
        trains.stream().allMatch((t)->{return t.verify();});
     }

    /**
     * A convenience class to represent name-value pairs.
     */
    public static class Pair<K,T>{
        private K key;
        private T value;
        public K getKey() {
            return key;
        }
        public T getValue() {
            return value;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public void setValue(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Pair [key=" + key + ", value=" + value + "]";
        }
    }
}