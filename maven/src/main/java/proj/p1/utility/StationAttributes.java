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

package proj.p1.utility;
import proj.p1.RSStatus;
import proj.p1.TrainSystem;

public abstract class StationAttributes implements Verifiable{
    protected String name;
    protected RSStatus status;
    protected TrainSystem trainSystem;
    
    public StationAttributes(String name, RSStatus status, TrainSystem trainSystem) {
        this.name = name;
        this.status = status;
        this.trainSystem = trainSystem;
    }
    /**
     * Ensures the object is verfied.
     * @return true if the object is verified.
     */
    public boolean verify() { 
        return (name.isBlank() || name.isEmpty() );
    };
    /**
     * Closes the route.
     * @retunrs true if the object is being closed. otherwise false.
     */
    public boolean close(){
       if(this.status == RSStatus.ClosedForMaintenance) return false;
       this.status = RSStatus.ClosedForMaintenance;
       return true;
    }
    /**
     * Opens the route.
     * @retunrs true if the object is being closed; otherwise, false.
     */
    public boolean open(){
       if(this.status == RSStatus.Open) return false;
       this.status = RSStatus.Open;
       return true;
    }
    public String getName() {
        return name;
    }
    public RSStatus getStatus() {
        return status;
    }
}
