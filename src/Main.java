import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pet> petList = setPet();
//        Сортировка в потоке по возрасту по возрастанию
        petList.stream().sorted(Comparator.comparing(Pet::getAge)).forEach(System.out::println);
        System.out.println();
//        Сортировка в потоке по возрасту по убыванию
        petList.stream().sorted(Comparator.comparing(Pet::getAge).reversed()).forEach(System.out::println);
        System.out.println();
//        Вывод только тех, у кого вес больше 10
        petList.stream().filter(m -> m.getWeight() >= 10).forEach(System.out::println);
        System.out.println();
//        Вывод с возрастом больше 7 включительно, группировка по возрасту
        petList.stream().filter(p -> p.getAge()>=7).collect(Collectors.groupingBy(Pet::getAge))
                .forEach((k, v) ->{
                    System.out.println(k);
                    System.out.println(v);
                });
        System.out.println();
//        Вывод с максимальным значением сначала по возрасту, потом по весу
        petList.stream().max(Comparator.comparing(Pet::getAge).thenComparing(Pet::getWeight)).ifPresent(System.out::println);
        System.out.println();
//        Вывод с минимальным значением сначала по возрасту, потом по весу
        petList.stream().min(Comparator.comparing(Pet::getAge).thenComparing(Pet::getWeight)).ifPresent(System.out::println);
        System.out.println();
//        anyMatch
        System.out.println(petList.stream().anyMatch(p -> p.getName().equals("Mars")));
        System.out.println();
//        allMatch
        System.out.println(petList.stream().allMatch(p -> p.getAge()==7));
        System.out.println();
//        nonMatch
        System.out.println(petList.stream().noneMatch(p -> p.getName().equals("Steve")));
    }
    public static List<Pet> setPet(){
        return Arrays.asList(new Pet("Jack", 3, 7.25),
                new Pet("Jim", 2, 10),
                new Pet("Max", 14, 15.3),
                new Pet("Mars", 7, 4.5),
                new Pet("Steve", 7, 12),
                new Pet("Jack", 14, 20));
    }
}
class Pet{
    private final String name;
    private final int age;
    private final double weight;

    public Pet(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}