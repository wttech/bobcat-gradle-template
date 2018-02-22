package @packageName@;

import com.cognifide.qa.bb.modules.CoreModule;
import com.cognifide.qa.bb.cumber.guice.BobcumberModule;
import com.google.inject.AbstractModule;

/**
 * This is an example implementation of Guice's module that you can use in your BDD project.
 * <p/>
 * Extend it by adding more modules or custom bindings.
 * <p/>
 * This module installs two basic Bobcat modules:
 * <ul>
 * <li>CoreModule -- all core functionality, like scope PageObjects or FrameSwitcher.
 * </ul>
 */
public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    if (System.getProperty("configuration.paths") == null) {
      System.setProperty("configuration.paths", "src/main/config/dev;src/main/config/common");
    }
    install(new CoreModule());
    install(new BobcumberModule());
  }

}
