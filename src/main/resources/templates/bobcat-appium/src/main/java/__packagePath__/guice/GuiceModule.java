package @packageName@.guice;

import com.cognifide.qa.bb.logging.ReporterModule;
import com.cognifide.qa.bb.modules.CoreModule;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

  public void configure() {
    install(new CoreModule());
    install(new ReporterModule());
  }

}
