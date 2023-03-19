package com.example.paymentgateway.payment.Service;

public class Util {
    public static Boolean verifyVendorCode(String code){
        if(code.substring(0,3).equals("GHR")){
            return true;
        }
            return false;
    }
    public static String createAccountNo(){
        Long min = Long.valueOf(111111);
        Long max = Long.valueOf(999999);
        Long id = (long) (Math.random() * (max - min + 1) + min);
        String accountNo="2121"+id;
        return accountNo;
    }
    


}
