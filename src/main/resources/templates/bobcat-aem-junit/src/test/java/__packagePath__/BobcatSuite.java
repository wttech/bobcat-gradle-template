package @packageName@;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.concurrent.ConcurrentSuite;

import @packageName@.GuiceModule;
import @packageName@.feedback.StartFormComponentTest;
import @packageName@.login.AuthorizationTest;
import @packageName@.summer.ImageComponentTest;
import @packageName@.summer.SectionHeaderComponentTest;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({ AuthorizationTest.class, ImageComponentTest.class, SectionHeaderComponentTest.class,
		StartFormComponentTest.class })
public class BobcatSuite {

}
