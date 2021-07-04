package org.example;

/**
 * @author lvle
 * @date 2021-02-20 22:47
 *
 * 如果try语句里有return，返回的是try语句块中变量值。
 * 详细执行过程如下：
 * a.如果有返回值，就把返回值保存到局部变量中；
 * b.执行jsr指令跳到finally语句里执行；
 * c.执行完finally语句后，返回之前保存在局部变量表里的值。
 * **如果try，finally语句里均有return，忽略try的return，而使用finally的return.
 *
 * 故可以看出基本类型finally不会改变其值，而引用类型存到局部变量的是引用而对应的内容会改变
 * 特例：String 是final的，finally中改变不会生效
 *
 */
public class FinallyReturnTest {

    public static void main(String[] args) {
        FinallyReturnTest finallyReturnTest = new FinallyReturnTest();
        int base = finallyReturnTest.testBase();
        System.out.println("base>> "+base);
        int[] packageArr = finallyReturnTest.testPackage();
        System.out.println("package>> "+packageArr[0]);
        int baseTwo = finallyReturnTest.testBaseCaseTwo();
        System.out.println("baseTwo>> "+baseTwo);
        StringBuffer stringBuffer = finallyReturnTest.testReferenceType();
        System.out.println("test reference>> "+stringBuffer.toString());
        StringBuffer stringBuffer2 = finallyReturnTest.testReferenceType2();
        System.out.println("test reference2>> "+stringBuffer2.toString());
        String s = finallyReturnTest.testSpecialReferenceType();
        System.out.println("test special>> "+s);
        String s1 = finallyReturnTest.testSpecialReferenceType2();
        System.out.println("test special 2 >>"+s1);
    }



    private int testBase(){
        int res = 0;
        try{
            return res;
        }catch (Exception e){
            System.out.println(">>>>>>异常");
        }finally {
            res++;
            System.out.println("base>>finally执行啦.........");
        }
        return res;
    }


    private int testBaseCaseTwo(){
        int res = 0;
        try{
            return res;
        }catch (Exception e){
            System.out.println(">>>>base case two");
        }finally {
            res++;
            System.out.println(">>>>base case two finally执行啦");
            return res;
        }
    }

    private StringBuffer testReferenceType(){
        StringBuffer str = new StringBuffer();
        str.append("reference");
        try{
            return str;
        }catch (Exception e){
            System.out.println("test reference>>>");
        }finally {
            str.append("test");
            System.out.println("test reference finally");
        }
        return str;
    }

    /**
     * 和testReferenceType 相同
     * @return
     */
    private StringBuffer testReferenceType2(){
        StringBuffer str = new StringBuffer();
        str.append("reference");
        try{
            return str;
        }catch (Exception e){
            System.out.println("test reference>>>");
        }finally {
            str.append("test");
            System.out.println("test reference 2 finally");
            return str;
        }

    }

    private String testSpecialReferenceType(){
        String str = "test";
        try{
            return str;
        }catch (Exception e){
            System.out.println("test special reference");
        }finally {
            str+="special";
            System.out.println("test special reference finally");
        }
        return str;
    }

    private String testSpecialReferenceType2(){
        String str = "test";
        try{
            return str;
        }catch (Exception e){
            System.out.println("test special reference");
        }finally {
            str+="special";
            System.out.println("test special reference 2 finally");
            return str;
        }
    }

    private int[] testPackage(){
        int[] res = new int[]{0};
        try{
            return res;
        }catch (Exception e){
            System.out.println("package异常>>>");
        }finally {
            res[0]++;
            System.out.println("package>>finally执行啦");
        }
        return res;
    }
}
