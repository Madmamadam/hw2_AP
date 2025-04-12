package org.example.test_hw2;

public class Change {
    public static double radius(double r){
        Constant cons = Constant.getinstance();
        if(cons.getCONSTANT_DECENT_MODE()){
            return r- cons.getDECENT_CONSTANT();
        }
        else {
            return r* cons.getDECENT_SCALE();
        }
    }
}
