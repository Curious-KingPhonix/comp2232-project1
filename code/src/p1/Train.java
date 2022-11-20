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

import p1.utility.Verifiable;

public class Train implements Verifiable {
    private Route route;
    private int id , timeRegistered , startTime;
    private Station currentLocation;
    
    public Train(int id) {
        this.id = id;
    }
    
    public Train(Route route, int id) {
        this.route = route;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public boolean isRegistered(){return true;}
    public boolean whenRegistered(){return true;}
    public int register(int time){return 0;}
    public void start(){}
    public void advance(){}
    public String currentStation(){return null;}
    public String nextStation(){return null;}
    public void changeRoute(Route route){}
    @Override public boolean verify() {return route.verify() && (this.id >0);}
}