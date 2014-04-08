package org.kie.spring;

import org.kie.api.KieBase;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.spring.beans.Person;
import org.springframework.context.ApplicationContext;

import javax.inject.Inject;

public class KieSpringUtil {

    @Inject
    ApplicationContext context;

    public void executeRules(Person person){
        KieBase kbase = (KieBase) context.getBean("kbase1");
        StatelessKieSession statelessKieSession =  kbase.newStatelessKieSession();
        statelessKieSession.execute(person);
    }

}
