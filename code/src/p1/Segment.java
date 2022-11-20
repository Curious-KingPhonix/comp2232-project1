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

public class Segment extends TrafficLight{
    private Station startStation , endStation;
    @Override public void acceptTrain(Train train) {super.acceptTrain(train);}
    @Override public boolean close() {return super.close();}
    @Override public boolean hasTrain() {return super.hasTrain();}
    @Override public boolean isOpen() {return super.isOpen();}
    @Override public boolean open() {return super.open();}
    @Override public void releaseTrain(Train train) {super.releaseTrain(train);}
    @Override public boolean verify() {return super.verify();}  
}