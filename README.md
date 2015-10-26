## NumberPick ##

![screenshot][1]

## Usage

**在Module的build.gradle里添加依赖：**

    dependencies {
        compile 'com.dd.numberpick:library:0.0.2'
    }

**NumberPick当做普通控件添加到layout里：**

    <com.dd.numberpick.NumberPick
        android:id="@+id/np"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:max="10"
        app:min="0"
        app:number="4" />

**提供的接口回调：**

    mNp = (NumberPick) findViewById(R.id.np);
    mNp.setOnNumberPickListener(new NumberPick.OnNumberPickListener() {
        @Override
        public void onSub(int number) {
            //do something
        }

        @Override
        public void onAdd(int number) {
            //do something
        }
    });

**设置初始化值：**

    mNp.setNumber(10);

**设置最大值：**

    mNp.setMax(10);

**设置最小值：**

    mNp.setMin(0);

 **获取值：**

    //获取当前值
    mNp.getNumber();
    //获取最大值
    mNp.getMax();
    //获取最小值
    mNp.getMin();

## TODO

 - 设置边框颜色
 - 设置字体大小
 - 设置字体颜色
 - 设置边框圆角大小

##LICENSE

    Copyright 2015 DaiDong

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


  [1]: https://github.com/DaidongStudio/NumberPick/blob/master/np.gif