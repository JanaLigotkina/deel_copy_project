# Тестовое задание

## Описание

Это тестовое задание, в котором реализован метод deepCopy(). Метод работает на объектах произвольной структуры и размера, учитывая все нюансы, включая примитивные типы, строки, числа, булевы значения, массивы и коллекции.

## Использование

```java
import com.yourpackage.CopyUtils;

Man originalMan = new Man("John", 30, favoriteBooks);
Man copiedMan = CopyUtils.deepCopy(originalMan);
