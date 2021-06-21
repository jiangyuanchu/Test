package jyc.annotation.annoHandler;

public interface BaseAnnotationHandler {

    Object[] param = null;

    Object annotationLocation = null;

    <T> void run(T annotationLocation, String className, Object... param);

}
