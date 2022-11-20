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

public class TrafficLight extends Station{
    private int id;
    private Light colour;
    
    public TrafficLight(String name, RSStatus status, int id, Light colour) {
        super(name, status);
        this.id = id;
        this.colour = colour;
    }

    public TrafficLight(String name, RSStatus status) {
        super(name, status);
    }
    
    public TrafficLight(String name) {
        super(name);
    }

    protected void change(){if(this.colour == Light.Red) this.colour=Light.Green; else this.colour = Light.Red; }
    public void changeLight() {this.change();};
    public boolean lightColour(){return (this.colour==Light.Green);}
    @Override public boolean verify() {return (colour != null);}
}