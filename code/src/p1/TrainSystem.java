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

public class TrainSystem implements Verifiable{
    private ArrayList<Route> routes;
    private HashMap<Pair<Station,Station>,Segment> routesTree;
    
    private SystemStatus status;
    public void addStation(String name){}
    public void removeStation(String name){}
    public void openStation(String name){}
    public void closeStation(String name){}
    public void addSegment(String name){}
    public void removeSegment(String name){}
    public void openSegment(String name){}
    public void closeSegment(String name){}
    public void addRoute(String name){}
    public void removeRoute(String name){}
    public void openRoute(String name){}
    public void closeRoute(String name){}
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
    @Override public boolean verify() { return false; }

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