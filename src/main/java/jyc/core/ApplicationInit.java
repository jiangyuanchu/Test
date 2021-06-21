package jyc.core;

import jyc.annotation.ApplicationScannerRootPath;
import jyc.annotation.annoHandler.ScannerPathHandler;

public class ApplicationInit extends ScannerPathHandler{

    public ApplicationInit(){}

    public ApplicationInit(Class clazz){
        mainAnnotationReader(clazz);

    }

    public void mainAnnotationReader(Class clazz){
        ApplicationScannerRootPath annotation = (ApplicationScannerRootPath)clazz.getAnnotation(ApplicationScannerRootPath.class);
        if(annotation != null){
            scannerPathInit(clazz);
            applicationAnnotationScanner(clazz);
        }
    }
}
