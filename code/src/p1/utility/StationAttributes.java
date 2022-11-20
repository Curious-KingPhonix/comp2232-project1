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

package p1.utility;
import p1.RSStatus;
import p1.TrainSystem;

public abstract class StationAttributes implements Verifiable{
    protected String name;
    protected RSStatus status;
    protected TrainSystem trainSystem;
    
    public StationAttributes(String name, RSStatus status, TrainSystem trainSystem) {
        this.name = name;
        this.status = status;
        this.trainSystem = trainSystem;
    }

    public boolean verify(){ return (name.isBlank() || name.isEmpty() ); };
    public boolean close(){
       if(this.status == RSStatus.ClosedForMaintenance) return false;
       this.status = RSStatus.ClosedForMaintenance;
       return true;
    }
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
