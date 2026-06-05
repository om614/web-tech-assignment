package beans;

public class MainPersonBean {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Alice");
        p.setAge(25);

        System.out.println("Person bean:");
        System.out.println("name=" + p.getName());
        System.out.println("age=" + p.getAge());
    }
}

