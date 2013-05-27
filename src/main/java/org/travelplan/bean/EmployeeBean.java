package org.travelplan.bean;

import java.io.Serializable;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session") //JSR-330 standart
public class EmployeeBean implements Serializable{

}
