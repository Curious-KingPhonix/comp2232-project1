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

import p1.utility.AbstractStation;
import p1.utility.LightListener;

public class Segment extends AbstractStation implements Comparable<Segment> , LightListener{
    private Station segmentStart , segmentEnd;
    private TrafficLight trafficLight;
    private ArrayList<Route> routes;
    
    public Segment(String name, RSStatus status, TrainSystem trainSystem, Train currentTrain) {
        super(name, status, trainSystem, currentTrain);
        this.trafficLight = new TrafficLight(0, Light.Red, this);
    }

    @Override public void changeLight() {this.trafficLight.change();};

    @Override public boolean lightColour() {return (this.trafficLight.getColour()==Light.Green);}

    public Station getStartStation() {
        return segmentStart;
    }
    public Station getEndStation() {
        return segmentEnd;
    }
    @Override public boolean verify() {
        boolean superVar = super.verify() &&
        this.segmentStart.verify() && this.segmentEnd.verify() &&
        !this.segmentStart.equals(this.segmentEnd) 
        && this.segmentStart.getStatus() == this.segmentEnd.getStatus() 
        && this.segmentStart.getStatus() == RSStatus.Open;
        return superVar;
    }
    /**
     * Compares an instance of {@code Segment} with another {@code Segment} object.<br>
     * @param o
     * @return A non-negative integer in the range [0,1]. 0 represents no match while 1 means there's a match by name or by station.
     */
    @Override public int compareTo(Segment o) {
        return ((this.name == o.name || this.segmentStart == o.segmentStart && this.segmentEnd == o.segmentEnd)?1:0);
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
}