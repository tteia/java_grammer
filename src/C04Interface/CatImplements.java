package C04Interface;

public class CatImplements implements AnimalInterface01{
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}
class CatMultiImplements implements AnimalInterface01, AnimalInterface02{

    @Override
    public void makeSound() {
        System.out.println("야옹");
    }

    @Override
    public String play(String a, String b) {
        return a+"와 "+b+"가 같이 뛰어놉니다.";
    }
}