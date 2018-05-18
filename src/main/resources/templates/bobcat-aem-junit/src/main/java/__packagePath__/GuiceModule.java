package @packageName@;

import com.cognifide.qa.bb.modules.CoreModule;
import com.cognifide.qa.bb.AemClassicModule;
import com.cognifide.qa.bb.logging.ReporterModule;
import com.google.inject.AbstractModule;

/**
 * Your Guice module.
 * <p/>
 * The three modules that are installed here are probably the minimum that you'll want to have in your project.
 * <p/>
 * CoreModule -- all core functionality, like scope PageObjects or FrameSwitcher.
 * AemClassicModule -- all common AEM elements.
 * ReporterModule -- reporting functionality, including reporting rule and HTML report.
 */
public class GuiceModule extends AbstractModule {
	@Override
	protected void configure() {
		install(new CoreModule());
		install(new AemClassicModule());
		install(new ReporterModule());
	}
}
