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

public abstract class AbstractStation implements Verifiable{
    protected String name;
    protected RSStatus status;
    private boolean IN_USE = true;
    public AbstractStation() {
        this.IN_USE = false;
    }
    public AbstractStation(String name) {
        this.name = name;
        this.status = RSStatus.Open;
    }
    public AbstractStation(String name, RSStatus status) {
        this.name = name;
        this.status = status;
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
}