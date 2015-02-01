package org.drools.examples.kredit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by sbacher on 01.02.2015.
 */
public class KreditTest {

    private static KieContainer kieContainer;
    private KieSession ksession;

    @BeforeClass
    public static void initKB() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();
    }

    @Before
    public void setUp() throws Exception {
        ksession = kieContainer.newKieSession("CashFlowKS");
        ksession.addEventListener(new DebugRuleRuntimeEventListener());
        ksession.addEventListener(new DebugAgendaEventListener());
    }
}
