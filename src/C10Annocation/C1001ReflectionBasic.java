package C10Annocation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C1001ReflectionBasic {
    public C1001ReflectionBasic() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    // 객체생성방법 1. 기존의 방식과 메서드 호출
        Calculator calculator = new Calculator("Samsung");
        calculator.sayHello();
        // 객체생성방법2. 런타임 환경에서 리플렉션 기술을 통해 객체 생성 및 메서드 호출
        // <?> : 제네릭 표현으로 어떤 클래스 타입도 가능하다는 표현.
        // getClass 메서드는 런타임시점에 calculator 라는 객체의 타입을 가져오는 메서드.
        Class<?> myClass = calculator.getClass();
        // 객체 생성 2-1)
        Calculator cal1 = (Calculator) myClass.getConstructor(String.class).newInstance("Samsung");
        // 메서드 생성
        Method cal1Method = myClass.getMethod("sayHello");
        cal1Method.invoke(cal1);

        // 객체 생성 2-2)
        Calculator cal2 = Calculator.class.getConstructor(String.class).newInstance("Casio");
        // 메서드 생성
        Method cal2Method = Calculator.class.getMethod("sayHello");
        cal2Method.invoke(cal2);


        // 리플렉션 기술을 통해 필드 접근 및 수정
        Field nameField = Calculator.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(cal1, "Casio");
        cal1Method.invoke(cal1);
    }

}

class Calculator{
    private String name;
    public Calculator(){ // 깡통생성자

    }
    public Calculator(String name){
        this.name = name;
    }
    public void sayHello(){
        System.out.println("my name is " + this.name);
    }
}