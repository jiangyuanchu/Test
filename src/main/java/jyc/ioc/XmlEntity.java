package jyc.ioc;

import lombok.Data;

import java.io.Serializable;

@Data
public class XmlEntity implements Serializable {

    private static final long serialVersionUID = -892861589986158560L;

    private String beanName;

    private String className;

    private String interfaceName;

}
