package circus;

import circus.animal.Animal;
import circus.animal.Bird;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

public class Trainer {
    public static void main(String[] args) {
        Duck d = new Duck("Donald");
        getToSpeak(d);

        Bird b = (Bird) d;  // upcasting
        getToSpeak(b);

        Animal a = (Animal) b; // upcasting
        getToSpeak(a);

        Duck d2 = (Duck) a; // downcasting
        getToSpeak(d2);

        train(new Duck("Daisy"));
        // train(new animal.Parrot());
    }

    private static void getToSpeak(Animal animal) {
        System.out.println(animal.speak());
    }

    private static void train(Bird bird) {
        if (bird instanceof Duck) {
            Duck d = (Duck) bird;
            d.swim();
        }
    }

    public static class Circus {
        private static Animal[] animals = {
                new Duck("Drake"),
                new Parrot("Polly")
        };
        private static Equipment[] equipments = {
                new Ladder(50),
                new Cannon(5),
                new Cannon(100)
        };

        private static void makeAnimalsTalk() {
            for (Animal a : animals) {
                System.out.println(a);
                System.out.println(a.speak());
            }
        }

        private static int calculateAssetValue(Asset[] assets) {
            int total = 0;
            for (Asset a : assets) {
                if (a.getValue() <= 5) {
                    System.out.println("Ignoring low value item: " + a.getValue());
                    continue;
                }
                total += a.getValue();
                System.out.println("Adding item value: " + a.getValue());
            }
            return total;
        }

        public static void main(String[] args) {
            makeAnimalsTalk();
            System.out.println("Total value of animals " + calculateAssetValue(animals));
            System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        }
    }
}
