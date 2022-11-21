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

import java.util.ArrayList;

public class Searcher {
    public static <T extends StationAttributes> T getElementByName(ArrayList< T > elementList, String name){
        T searchElement = null; 
        for (T searchQuery : elementList) {
            if( searchQuery.name == name) searchElement = searchQuery;
        }
        return searchElement;
    }

    /* Consider making a factory function for Station,Segment & Route.   
    public static <T extends StationAttributes> void add(ArrayList<T> list,String name){
        list.add();
    } */
    public static <T extends StationAttributes> void remove(ArrayList<T> list,String name){
        T stat = Searcher.getElementByName(list, name);
        if( stat != null ) list.remove(stat);
    }
    public static <T extends StationAttributes> void open(ArrayList<T> list,String name){
        T stat = Searcher.getElementByName(list, name);
        if( stat != null ){
            stat.open();
        }
    }
    public static <T extends StationAttributes> void close(ArrayList<T> list,String name){
        T stat = Searcher.getElementByName(list, name);
        if( stat != null ){
            stat.close();
        }
    }
}
