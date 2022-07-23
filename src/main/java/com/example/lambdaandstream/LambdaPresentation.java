package com.example.lambdaandstream;

import java.util.concurrent.Callable;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class LambdaPresentation {
    public static void main(String[] args) throws Exception {
        // 1. Lambda - metoda bez przynależności do jakiejkolwiek klasy

        // 2. składnia: <parametry> -> <wyrażenie>

        // 2.1. Bez parametrowe
        Callable<String> stringCallable = () -> "some value";
        System.out.println(stringCallable.call());
        //Callable Supplier;
        Supplier<String> runnable = () -> "some value but another";
        System.out.println(runnable.get());


        // 2.2. Z jednym parametrem
        UnaryOperator<Integer> up = x -> x * x;
        // UnaryOperator Function BiConsumer
        System.out.println(up.apply(5));

        // 3. Złożone wyrażenie
        UnaryOperator<Integer> up2 = x -> {
            System.out.println("In method" + x);
            int multiplication = x * x;
            System.out.println("In method" + multiplication);
            return x * x;
        };
        System.out.println(up2.apply(2));

        // 4. Funtional interface - kompilator się upewni, że jest jedna abstrakcyjna metoda
        Car car = () -> "driving";
        System.out.println(car.drive());
        // 4.1. Default i static

        Animal animal = () -> "I am swimming";
        System.out.println(animal.move());


        Animal dog = new Dog();
        dog.makeASound();
        Animal.eat();

        // 5. wywołanie przez referencje
        Object objectInstance1 = new Object();
        IntSupplier equalsMethodOnObject = objectInstance1::hashCode;
        System.out.println(equalsMethodOnObject.getAsInt());

        // 5.1. Wywołanie bez instancji klasy na której powinna być wywołana metoda
        ToIntFunction<Object> hashCodeMethodOnClass = Object::hashCode;
        Object objectInstance = new Object();
        System.out.println(hashCodeMethodOnClass.applyAsInt(objectInstance));

        // 7. Do czego nam lambdy? -> głównie do operacji na kolekcjach


    }
}

@FunctionalInterface
interface Car {
    String drive();
}

@FunctionalInterface
interface Animal {
    String move();

    default void makeASound() {
        System.out.println("some sound");
    }

    static void eat(){
        System.out.println("I am eating");
    }
}

class Dog implements Animal {

    @Override
    public String move() {
        return "I am running";
    }
}