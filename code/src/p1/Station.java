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
    public boolean hasTrain(){return false;}
    public boolean isOpen(){return false;}
    public void acceptTrain(Train train){}
    public void releaseTrain(Train train){}
    @Override public boolean close() {return false;}
    @Override public boolean open() {return false;}
    @Override public boolean verify() {return false;} 
}