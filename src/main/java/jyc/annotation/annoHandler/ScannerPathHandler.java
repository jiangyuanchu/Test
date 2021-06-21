package jyc.annotation.annoHandler;

import jyc.annotation.ApplicationAnnotationScanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScannerPathHandler extends ApplicationAnnotationScanner {

    public static String classPath;

    public void scannerPathInit(Class clazz){
        classPath = clazz.getPackage().getName();
        log.info("读取扫描类路径:{}", classPath);
    }

    public String getClassPath(){
        return classPath;
    }

    public ScannerPathHandler(Class clazz){
        scannerPathInit(clazz);
    }

    public ScannerPathHandler(){}
}
