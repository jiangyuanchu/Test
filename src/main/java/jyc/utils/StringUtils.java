package jyc.utils;

public class StringUtils {

    public String classNameToBeanName(String className){
        String[] name = className.split("\\.");
        return name[name.length - 1].substring(0, 1).toLowerCase() + name[name.length - 1].substring(1);
    }

    public String classNameToAnnoName(Class clazz){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(clazz.getName());
        stringBuffer.append("()");
        return stringBuffer.toString();
    }

}
