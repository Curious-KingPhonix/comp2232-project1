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
    /**
     * A convenience class to represent name-value pairs.
     */
public class Pair<K,T>{
        private K key;
        private T value;
        public K getKey() {
            return key;
        }
        public T getValue() {
            return value;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public void setValue(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Pair [key=" + key + ", value=" + value + "]";
        }
}