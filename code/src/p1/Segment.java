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

public class Segment extends TrafficLight implements Comparable<Segment>{
    private Station startStation , endStation;
    
    public Segment(String name, RSStatus status, Station startStation, Station endStation) {
        super(name, status);
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public Segment(String name) {
        super(name);
    }

    public Station getStartStation() {
        return startStation;
    }
    public Station getEndStation() {
        return endStation;
    }
    @Override public void acceptTrain(Train train) {super.acceptTrain(train);}
    @Override public boolean close() {return super.close();}
    @Override public boolean hasTrain() {return super.hasTrain();}
    @Override public boolean isOpen() {return super.isOpen();}
    @Override public boolean open() {return super.open();}
    @Override public void releaseTrain(Train train) {super.releaseTrain(train);}
    @Override public boolean verify() {
        boolean superVar = super.verify() &&
        this.startStation.verify() && this.endStation.verify() &&
        !this.startStation.equals(this.endStation) 
        && this.startStation.status == this.endStation.status 
        && this.startStation.status == RSStatus.Open;
        return superVar;
    }
    /**
     * Compares an instance of {@code Segment} with another {@code Segment} object.<br>
     * @param o
     * @return A non-negative integer in the range [0,1]. 0 represents no match while 1 means there's a match by name or by station.
     */
    @Override public int compareTo(Segment o) {
        return ((this.name == o.name || this.startStation == o.startStation && this.endStation == o.endStation)?1:0);
    }
}