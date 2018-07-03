package @packageName@;

import com.cognifide.qa.bb.modules.CoreModule;
import com.cognifide.qa.bb.AemClassicModule;
import com.cognifide.qa.bb.cumber.guice.BobcumberModule;
import com.google.inject.AbstractModule;
import com.cognifide.qa.bb.aem.AemCommonModule;

/**
 * This is an example implementation of Guice's module that you can use in your BDD project.
 * <p/>
 * Extend it by adding more modules or custom bindings.
 * <p/>
 * This module installs two basic Bobcat modules:
 * <ul>
 * <li>CoreModule -- all core functionality, like scope PageObjects or FrameSwitcher.
 * <li>AemClassicModule -- all common AEM elements.
 * </ul> 
 */
public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new CoreModule());
		install(new AemClassicModule());
		install(new AemCommonModule());
		install(new BobcumberModule());
	}

}
