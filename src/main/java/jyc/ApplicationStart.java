package jyc;

import jyc.annotation.ApplicationScannerRootPath;
import jyc.aop.LeetCodeBase;
import jyc.core.ApplicationInit;
import jyc.ioc.BeanFactory;
import jyc.ioc.XmlHandler;
import jyc.leetcode.LeetCode12;

@ApplicationScannerRootPath
public class ApplicationStart {

    public static void main(String[] args){

        ApplicationInit applicationInit = new ApplicationInit(ApplicationStart.class);

        try{
            BeanFactory beanFactory = BeanFactory.getBeanFactory();
            LeetCodeBase leetCodeBase = (LeetCodeBase)beanFactory.getBean("leetCode12");
            LeetCodeBase leetCodeBase2 = (LeetCodeBase)beanFactory.getBean("leetCode12");
            System.out.println(leetCodeBase.equals( leetCodeBase2));
        }catch(Exception e){
            e.printStackTrace();
        }
//        BeanFactory beanFactory = BeanFactory.getBeanFactory();
//        try {
//            LeetCodeBase leetCode12 = (LeetCodeBase)beanFactory.getBean("leetCode52");
//            leetCode12.run(null);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


//        ApplicationAnnotationScanner applicationAnnotationScanner = new ApplicationAnnotationScanner();
//        HashMap<String, String> hashMap = applicationAnnotationScanner.annotationHandlerMap;
//        System.out.println("自定义注解自动扫描器");
//        for (String key : hashMap.keySet()){
//            System.out.println(hashMap.get(key));
//        }

//        System.out.println(Math.round(-1.5));
    }

}
