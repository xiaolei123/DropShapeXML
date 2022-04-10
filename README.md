# 丢掉你的Shape selector layer_list XML文件

项目里的```shape.xml``` ```selector.xml```  ```layer_list.xml``` 文件太多啦

想个办法替代吧：

### 1. shape.xml 的替代法

 - 旧写法 - shape.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#f00000"/>
    <corners android:radius="15dp"/>
</shape>
```

 - 新写法-kotlin
```kotlin
textView.background = shape {
    shape = RECTANGLE
    solid { color = Color.parseColor("#f00000") }
    corners { radius = 15f.dp }
}
```

> xml 里所有的属性都支持

### 2. selector.xml 的替代法

 - 旧写法 - selector.xml

 normal.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#f00000"/>
    <corners android:radius="15dp"/>
</shape>
```

 pressed.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#00f000"/>
    <corners android:radius="15dp"/>
</shape>
```

 selector.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/pressed" android:state_pressed="true"/>
    <item android:drawable="@drawable/normal" android:state_pressed="false"/>
</selector>
```

 - 新写法 - kotlin
```kotlin
textView.background = selector {
    item {
        drawable = shape {
            shape = RECTANGLE
            solid { color = Color.parseColor("#f00000") }
            corners { radius = 15f.dp }
        }
        state_pressed = false
    }
    item {
        drawable = shape {
            shape = RECTANGLE
            solid { color = Color.parseColor("#00f000") }
            corners { radius = 15f.dp }
        }
        state_pressed = true
    }
}
```

### 3. layer_list.xml 的替代法

 - 旧写法 - layer_list.xml

```
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape android:shape="rectangle">
            <solid android:color="#C15454" />
            <corners android:radius="15dp" />
        </shape>
    </item>
    <item android:top="50dp">
        <shape android:shape="rectangle">
            <solid android:color="#155473" />
            <corners
                android:bottomLeftRadius="15dp"
                android:bottomRightRadius="15dp" />
        </shape>
    </item>
</layer-list>
```

 - 新写法 - kotlin

 ```kotlin
layerList {
    item {
        drawable = shape {
            solid { color = Color.parseColor("#C15454") }
            corners { radius = 15f.dp }
        }
    }
    item {
        top = 50.dp
        drawable = shape {
            solid { color = Color.parseColor("#155473") }
            corners {
                leftBottomRadius = 15f.dp
                rightBottomRadius = 15f.dp
            }
        }
    }
}
 ```

### 4. selector_color.xml 颜色选择的替代法

 - 旧写法 - selector_color.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@color/green" android:state_pressed="true"/>
    <item android:drawable="@color/white" android:state_pressed="false"/>
</selector>
```
 - 新写法 - kotlin
```kotlin
textView.setTextColor(colorSelector {
     item {
         state_pressed = true
         color = Color.WHITE
     }
     item {
         state_pressed = false
         color = Color.GREEN
     }
 })
```

### 5. todo
接下来准备实现 bitmap.xml
...
