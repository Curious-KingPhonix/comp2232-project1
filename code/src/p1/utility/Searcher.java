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
import java.util.Collection;

public class Searcher {
    /**
     * Searches a {@code Collection} of classes that extends the StationAttributes class and returns it.<br>
     * This method iterates through the {@code Collection} and returns a reference to the class who's name attribute matches the parameter.
     * @param <T> A class that extends {@code StationAttributes}
     * @param elementList A @{code Collection} of classes to search through.
     * @param name The name of a {@code StationAttributes} child class to search for. 
     * @return A reference to {@code StationAttributes} subclass that matches the parameter. Otherwise, returns null.
     */
    public static <T extends StationAttributes> T getElementByName(Collection< T > elementList, String name){
        T searchElement = null; 
        for (T searchQuery : elementList) {
            if( searchQuery.name == name) searchElement = searchQuery;
        }
        return searchElement;
    }

    /* Consider making a factory function for Station,Segment & Route.   
    public static <T extends StationAttributes> void add(Collection<T> list,String name){
        list.add();
    } */

    /**
     * Searches a {@code Collection} of classes that extends the StationAttributes class and attempts to remove it.<br>
     * This method iterates through the {@code Collection} and removes the element from the list who's name attribute matches the parameter.
     * @param <T> A class that extends {@code StationAttributes}
     * @param elementList A @{code Collection} of classes to search through.
     * @param name The name of a {@code StationAttributes} child class to search for. 
    */
    public static <T extends StationAttributes> void remove(Collection<T> elementList,String name){
        T stat = Searcher.getElementByName(elementList, name);
        if( stat != null ) elementList.remove(stat);
    }
    /**
     * Searches a {@code Collection} of classes that extends the StationAttributes class and attempts to opens it.<br>
     * This method iterates through the {@code Collection} and opens element who's name attribute matches the parameter.
     * @param <T> A class that extends {@code StationAttributes}
     * @param elementList A @{code Collection} of classes to search through.
     * @param name The name of a {@code StationAttributes} child class to search for. 
    */
    public static <T extends StationAttributes> void open(Collection<T> elementList,String name){
        T stat = Searcher.getElementByName(elementList, name);
        if( stat != null ){
            stat.open();
        }
    }
    /**
     * Searches a {@code Collection} of classes that extends the StationAttributes class and attempts to closes it.<br>
     * This method iterates through the {@code Collection} and closes the element who's name attribute matches the parameter.
     * @param <T> A class that extends {@code StationAttributes}
     * @param elementList A @{code Collection} of classes to search through.
     * @param name The name of a {@code StationAttributes} child class to search for. 
    */
    public static <T extends StationAttributes> void close(Collection<T> elementList,String name){
        T stat = Searcher.getElementByName(elementList, name);
        if( stat != null ){
            stat.close();
        }
    }
}
