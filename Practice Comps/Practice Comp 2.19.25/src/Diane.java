import java.util.*;
import java.io.*;

public class Diane{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("diane".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] l=f.nextLine().split(" and ");
            if(helper(l[0]).equals("int")  && helper(l[1]).equals("int")){
                System.out.println(Integer.parseInt(l[0])+Integer.parseInt(l[1]));
            }
            if(helper(l[0]).equals("pf")  &&helper(l[1]).equals("pf")  ){

                System.out.println(sumpf(l[0], l[1]));
            }
            if(helper(l[0]).equals("ipf")  &&helper(l[1]).equals("ipf")  ){

                System.out.println(sumipf(l[0], l[1]));
            }
            //mix
             if(helper(l[0]).equals("int")  &&helper(l[1]).equals("pf")  ){

                System.out.println(sumIntAndpf(l[0], l[1]));
            }
             if(helper(l[0]).equals("int")  &&helper(l[1]).equals("ipf")  ){

                System.out.println(sumIntAndipf(l[0], l[1]));
            }
             if(helper(l[0]).equals("pf")  &&helper(l[1]).equals("ipf")  ){

                System.out.println(sumpfAndipf(l[0], l[1]));
            }

        }

    }

    public String helper(String o){
        if (o.contains(" ") && o.contains("/")){
            return "ipf";
        }
        else if (o.contains("/")){
            return "pf";
        }
        return "int"       ;
    }
    public String convertPF(String ipf){
        String[] ar = ipf.split("\\s+");
        int wholeNum = Integer.parseInt(ar[0]);
        int num = Integer.parseInt(ar[1].substring(0, ar[1].indexOf("/")));
        if(wholeNum <0){num*=-1;}
        int deno = Integer.parseInt(ar[1].substring(ar[1].indexOf("/")+1));
        return (deno*wholeNum+num) + "/" + deno;
    }
    public String sumpf(String pf1, String pf2){
        int num1 = Integer.parseInt(pf1.substring(0,pf1.indexOf("/")));
        int deno1 = Integer.parseInt(pf1.substring(pf1.indexOf("/")+1));
        int num2 = Integer.parseInt(pf2.substring(0,pf2.indexOf("/")));
        int deno2 = Integer.parseInt(pf2.substring(pf2.indexOf("/")+1));
        int base = deno1*deno2;
        int top = num1*deno2 + num2*deno1;
        if(Math.abs(top) >base && top<base){
            return (top/base) +" " + top%base +"/" + base;
        }
        else if(top >base){
            return (top/base) +" " + top%base +"/" + base;
        }
        return top+"/"+base;
    }
    public String sumipf(String ipf1, String ipf2){
        return sumpf(convertPF(ipf1),convertPF(ipf2));
    }


    public String sumIntAndpf(String i, String pf){
        int num = Integer.parseInt(pf.substring(0,pf.indexOf("/")));
        int deno = Integer.parseInt(pf.substring(pf.indexOf("/")+1));
        int top = Integer.parseInt(i)*deno+num;
        int base = deno;
        if(top >base){
            return (top/base) +" " + top%base +"/" + base;
        }
        return top+"/"+base;

    }
    public String sumIntAndipf(String i, String ipf){
        return sumIntAndpf(i, convertPF(ipf));
    }
    public String sumpfAndipf(String pf, String ipf){
        return sumpf(pf,convertPF(ipf));
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Diane().run();
    }
}
