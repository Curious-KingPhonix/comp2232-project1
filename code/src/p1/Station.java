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

public class Station extends AbstractStation{
    private Train currentTrain;
    public Station(String name, RSStatus status) {
        super(name, status);
    }
    public Station(String name) {
        super(name);
    }
    /**
     * Checks if there's a train occupying this station or stop.
     * @return true if a train is currently docked in this station; otherwise, false.
     */
    public boolean hasTrain(){
        return (currentTrain == null);
    }
    /**
     * Checks if this station is open.
     * @return true if the station is open ; otherwise, false.
     */
    public boolean isOpen(){
        return this.status == RSStatus.Open;
    }

    /**
     * Sets a train as docked in this station.
     * @param train train to docked.
     */
    public void acceptTrain(Train train){
        if( this.currentTrain != null ) return;
        this.currentTrain = train;
    }
    /**
     * Removes train as docked in this station.
     * @param train
     */
    public void releaseTrain(Train train){
        if()
    }
}