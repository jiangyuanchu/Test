package jyc.ioc;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

@Slf4j
public class XmlHandler extends BeanFactory{

    private String fileName;

    public XmlHandler(String fileName){
        this.fileName = fileName;
        xmlReader();
    }

    private void xmlReader(){
        //读取配置文件
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        NodeList nodeList = null;
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            nodeList = doc.getElementsByTagName("bean");
        } catch (Exception e){
            log.error("IOC读取配置文件异常");
        }
        //单例模式，具体功能未实现
        if(doc.getElementsByTagName("pattern") != null){
            String pattern = doc.getElementsByTagName("pattern").item(0).getNodeValue();
        }
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++){
                for(int j = 0; j < doc.getElementsByTagName("beanName").getLength(); j++){
                    XmlEntity xmlEntity = new XmlEntity();
                    xmlEntity.setBeanName(doc.getElementsByTagName("beanName").item(j).getFirstChild().getNodeValue());
                    if(doc.getElementsByTagName("className") != null){
                        xmlEntity.setClassName(doc.getElementsByTagName("className").item(j).getFirstChild().getNodeValue());
                    }
                    if (doc.getElementsByTagName("interfaceName").item(j) != null) {
                        xmlEntity.setInterfaceName(doc.getElementsByTagName("interfaceName").item(j).getFirstChild().getNodeValue());
                    }
                    registerBean(xmlEntity.getBeanName(), xmlEntity);
                }
            }


        }



    }


}
