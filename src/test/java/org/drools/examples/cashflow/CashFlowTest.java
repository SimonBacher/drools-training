package org.drools.examples.cashflow;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by sbacher on 31.01.2015.
 */
public class CashFlowTest {

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

    @Test
    public void testCashflowRules() throws Exception {
        Account account1 = new Account(1, 0);
        Account account2 = new Account(2, 0);

        ksession.insert( account1 );
        ksession.insert( account2 );

        initCashflowAndFire();

        assertThat(account1.getBalance(), is(-25));
        assertThat(account2.getBalance(), is(80));

    }

    private void initCashflowAndFire() throws Exception {
        AccountPeriod acp = new AccountPeriod(date("2014-01-01"), date("2014-03-31"));

        CashFlow cf1 = new CashFlow(date( "2014-01-12"), 100, CashFlowType.CREDIT, 1 );
        CashFlow cf2 = new CashFlow(date( "2014-02-02"), 200, CashFlowType.DEBIT, 1 );
        CashFlow cf3 = new CashFlow(date( "2014-05-18"), 50, CashFlowType.CREDIT, 1 );
        CashFlow cf4 = new CashFlow(date( "2014-03-07"), 75, CashFlowType.CREDIT, 1 );
        CashFlow cf5 = new CashFlow(date( "2014-02-26"), 80, CashFlowType.CREDIT, 2);

        ksession.insert( acp );

        ksession.insert( cf1 );
        ksession.insert( cf2 );
        ksession.insert( cf3 );
        ksession.insert( cf4 );
        ksession.insert( cf5 );

        ksession.fireAllRules();
    }

    public Date date(String str) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.parse( str );
    }

}
