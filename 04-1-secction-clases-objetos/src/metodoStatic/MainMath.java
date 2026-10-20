package metodoStatic;

public class MainMath {


    public static void main(String[] args){
       int result = MathExample.add(3,3);

       System.out.println(" Resultado es "+result);


       MathExample mathExample = new MathExample();
       result = mathExample.rest(9,2);
        System.out.println(" Resultado es "+result);

        MathExample mathExample1 = new MathExample();
        result = mathExample1.rest(10,2);
        System.out.println(" Resultado es "+result);
    };


}
