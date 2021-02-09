package ru.trishkin.gb.lesson1;

public class CodeReview {

// указать уровень доступа public
//    interface Moveable {
//        void move();
//    }
//
//    //указать уровень доступа public
//    interface Stopable {
//        void stop();
//    }
//
//    // уровень доступа класса public
//    abstract class Car {
//        //переменная в публичном доступе,
//        //необходимо установить уровень доступа private
//        public Engine engine;
//        private String color;
//        private String name;
//
//        //уровень доступа protected здесь не нужен.
//        protected void start() {
//            System.out.println("Car starting");
//        }
//
//        //уровень доступа
//        abstract void open();
//
//        public Engine getEngine() {
//            return engine;
//        }
//
//        public void setEngine(Engine engine) {
//            this.engine = engine;
//        }
//
//        public String getColor() {
//            return color;
//        }
//
//        public void setColor(String color) {
//            this.color = color;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    public *
//    class LightWeightCar extends Car implements Moveable{
//
//        @Override
//        void open() {
//            System.out.println("Car is open");
//        }
//
//        @Override
//        public void move() {
//            System.out.println("Car is moving");
//        }
//
//    }
//
//    //множественного наследования в java нет
//    //так как речь идет о интерфейсах, необходим
//    //class Lorry extends Car implements Moveable, Stopable
//    class Lorry extends Car, Moveable, Stopable{
//
//        public void move(){
//            System.out.println("Car is moving");
//        }
//
//        public void stop(){
//            System.out.println("Car is stop");
//        }
//    }
}
