package thuchanh.abstractandinterface.manager;

import thuchanh.abstractandinterface.fruit.Apple;
import thuchanh.abstractandinterface.fruit.Fruit;
import thuchanh.abstractandinterface.fruit.Orange;

public class MainFruit {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];

        fruits[0] = new Apple();
        fruits[1] = new Orange();

        for (Fruit f: fruits) {
            System.out.println(f.howToEat());
        }
    }
}
