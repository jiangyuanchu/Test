package jyc.annotation;

import jyc.annotation.annoHandler.BaseAnnotationHandler;
import jyc.annotation.annoHandler.ScannerPathHandler;
import jyc.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
public class ApplicationAnnotationScanner {

    private static HashMap<String, String> annotationHandlerMap = new HashMap<>();

    private String mainClassName = null;

    private StringUtils stringUtils = new StringUtils();

    protected void applicationAnnotationScanner(Class clazz) {

        //入口类路径
        String className = clazz.getName();
        String[] classNameAlias = className.split("\\.");
        mainClassName = classNameAlias[1] + ".class";

        //全项目类路径容器
        ArrayList<String> classList = new ArrayList<>();

        //文件夹栈
        Stack<File> fileStack = new Stack<>();
        File file = new File(clazz.getResource("/").getPath() + "/" + ScannerPathHandler.classPath);
        fileIterator(file, fileStack, classList);
        while (!fileStack.isEmpty()) {
            file = fileStack.pop();
            fileIterator(file, fileStack, classList);
        }

        //自定义注解类 注册
        for (String str : classList) {
            annotationRegister(str);
        }

        //自定义注解全局匹配
        for (String str : classList) {
            annotationDistributor(str);
        }

    }

    private void annotationDistributor(String name) {
        Class clazz = null;
        try {
            clazz = Class.forName(name);
        } catch (ClassNotFoundException e) {
            log.error("{}类没有找到", name);
            e.printStackTrace();
        }
        //类注解容器
        ArrayList<Annotation> annoList = new ArrayList<>();
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations != null && annotations.length > 0) {
            annoList.addAll(Arrays.asList(annotations));
        }
        //方法注解容器
        HashMap<Method, List<Annotation>> methodsMap = new HashMap<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getDeclaredAnnotations();
            if (methodAnnotations != null && methodAnnotations.length > 0) {
                methodsMap.put(method, Arrays.asList(methodAnnotations));
            }
        }
        annotationMapping(methodsMap, name);
        //属性注解容器
        HashMap<Field, List<Annotation>> fieldsMap = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] methodAnnotations = field.getDeclaredAnnotations();
            if (methodAnnotations != null && methodAnnotations.length > 0) {
                fieldsMap.put(field, Arrays.asList(methodAnnotations));
            }
        }
        annotationMapping(fieldsMap, name);


        if (annoList.size() != 0) {
            for (Annotation annotation : annoList) {
                if (annotation instanceof Target || annotation instanceof Retention) {
                    return;
                }
                log.info("正在映射注解:{}", annotation.toString());
                if (annotationHandlerMap.containsKey(annotation.toString())) {
                    try {
                        Field[] annotationFields = annotation.getClass().getDeclaredFields();
                        BaseAnnotationHandler baseAnnotationHandler = (BaseAnnotationHandler) Class.forName(annotationHandlerMap.get(annotation.toString())).newInstance();
                        if (annotationFields == null || annotationFields.length == 0) {
                            baseAnnotationHandler.run(clazz, name);
                        } else {
                            baseAnnotationHandler.run(clazz, name, annotationFields);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    log.error("该注解不在自动映射管理范围");
                }
            }
        }

    }

    private <T> void annotationMapping(HashMap<T, List<Annotation>> hashMap, String className) {
        if (hashMap == null) {
            return;
        }
        for (T t : hashMap.keySet()) {
            for (Annotation annotation : hashMap.get(t)) {
                if (annotationHandlerMap.containsKey(annotation.toString())) {
                    log.info("正在映射注解:{}", annotation.toString());
                    try {
                        Field[] annotationFields = annotation.getClass().getDeclaredFields();
                        BaseAnnotationHandler baseAnnotationHandler = (BaseAnnotationHandler) Class.forName(annotationHandlerMap.get(annotation.toString())).newInstance();
                        if (annotationFields == null || annotationFields.length == 0) {
                            baseAnnotationHandler.run(t, className);
                        } else {
                            baseAnnotationHandler.run(t, className, annotationFields);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void fileIterator(File file, Stack stack, ArrayList<String> classList) {
        String[] filelist = file.list();
        for (int i = 0; i < filelist.length; i++) {
            File file2 = new File(file.getPath() + "/" + filelist[i]);
            if (!file2.isFile()) {
                stack.push(file2);
            } else {
                if (filelist[i].equals(mainClassName)) {
                    continue;
                }
                String[] fileNameList = filelist[i].split("\\.");
                StringBuffer classNameBufffer = new StringBuffer();
                classNameBufffer.append(file.getPath());
                classNameBufffer.append("\\");
                classNameBufffer.append(fileNameList[0]);
                String[] className = classNameBufffer.toString().split("classes.");
                classList.add(className[1].replaceAll("\\\\", "\\."));
            }
        }
    }

    private void annotationRegister(String name) {
        Class clazz = null;
        try {
            clazz = Class.forName(name);
        } catch (ClassNotFoundException e) {
            log.error("{}类没有找到", name);
            e.printStackTrace();
        }
        AnnotationAutoScan annotationAutoScan = (AnnotationAutoScan) clazz.getAnnotation(AnnotationAutoScan.class);
        if (annotationAutoScan != null) {
            log.info("注解类注册:{}", stringUtils.classNameToAnnoName(clazz));
            annotationHandlerMap.put(stringUtils.classNameToAnnoName(clazz), annotationAutoScan.value());
        }
    }
}
