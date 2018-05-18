package @packageName@;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.concurrent.ConcurrentSuite;
import @packageName@.login.AuthorizationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({AuthorizationTest.class})
public class BobcatSuite {

}
