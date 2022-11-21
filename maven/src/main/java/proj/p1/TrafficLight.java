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

package proj.p1;

import proj.p1.utility.Verifiable;

public class TrafficLight implements Verifiable{
    private int id;
    private Light colour;
    private Segment segment;
    
    public TrafficLight(int id, Light colour, Segment segment) {
        this.id = id;
        this.colour = colour;
        this.segment = segment;
    }
    
    public int getId() {
        return id;
    }
    public Light getColour() {
        return colour;
    }
    protected void change(){if(this.colour == Light.Red) this.colour=Light.Green; else this.colour = Light.Red; }
    @Override public boolean verify() {return (colour != null);}
}